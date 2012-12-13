antblink
========

Ant task to control a [blink(1)](https://github.com/todbot/blink1).

This is slightly annoying to use as you'll need to set the ANT_OPTS environment variable to update java.library.path to include the directory where you have the blink(1) JNI libs. (i.e. export ANT_OPTS="-Djava.library.path=/blah/dir $ANT_OPTS").