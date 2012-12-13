antblink
========

Some Ant utils to interface with a [blink(1)](https://github.com/todbot/blink1). 

It includes a blink task to set the blink(1) to the specified color.  It also includes a customer BuildLister that will indicate the build status by flashing the blink (green for success, red for failure).

This is slightly annoying to use as you'll need to set the ANT_OPTS environment variable to update java.library.path to include the directory where you have the blink(1) JNI libs. (i.e. export ANT_OPTS="-Djava.library.path=/path/to/blink JNI libs $ANT_OPTS").

To use the BuildListener:

* Copy antblink.jar to $ANT_HOME/lib
* Set $ANT_ARGS to "-listener net.slimeslurp.antblink.BlinkListener"
* Update $ANT_OPTS to include -Djava.library.path=/path/to/blink JNI libs 
