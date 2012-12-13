/*
 *  Copyright 2012 Nate Drake
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License"); 
 *  you may not use this file except in compliance with the License. 
 *  You may obtain a copy of the License at 
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software 
 *  distributed under the License is distributed on an "AS IS" BASIS, 
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 *  See the License for the specific language governing permissions and 
 *  limitations under the License.
 */

package net.slimeslurp.antblink;

import java.awt.Color;

import org.apache.tools.ant.BuildListener;
import org.apache.tools.ant.BuildEvent;

import thingm.blink1.*;

/**
 * BuildListener that displays build status info via blink(1) device.
 *
 *
 * @author ndrake
 *
 */
public class BlinkListener implements BuildListener {


    private Blink1 blink1;
    
    public BlinkListener() {


    }

    /**
     * Called when the build is started.
     *
     * @param event
     */
    public void buildStarted(BuildEvent event) {        
        
    }

    /**
     * Called when the build is finished.
     *
     * @param event
     */
    public void buildFinished(BuildEvent event) {
        Throwable t = event.getException();

        if (t != null) {
            doBlink(Color.red);
        } else {                    
            doBlink(Color.green);
        }
    }

    // Other messages are currently ignored
    public void messageLogged(BuildEvent event) { }
    public void targetFinished(BuildEvent event) {}
    public void targetStarted(BuildEvent event) {}
    public void taskFinished(BuildEvent event) {}
    public void taskStarted(BuildEvent event) {}

    protected void doBlink(Color c) {
        Blink1 blink1 = new Blink1();
        int rc = blink1.open();
        if( rc != 0 ) { 
          System.err.println("uh oh, no Blink1 device found");
          return;
        }
        
        // FIXME: Change this to support blink(1) patterns
        rc = blink1.setRGB( c );
        blink1.pause(1000);        
        blink1.setRGB(Color.black);
        blink1.pause(500);
        rc = blink1.setRGB( c );
        blink1.pause(1000);        
        blink1.setRGB(Color.black);
        blink1.pause(500);        
        rc = blink1.setRGB( c );
        blink1.pause(1000);                
        blink1.setRGB(Color.black);
        blink1.pause(500);        
        blink1.close();        
    }


}