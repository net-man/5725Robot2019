# Team FRC 5725 Robot Code



## DriveTrain
Figure out how to get an x and y from motor encoders. I believe we are pretty close figuring this one out.

### THE THING WE KNOW ARE:
* Right distance : (right wheel rotations * wheel circumference)
* Left distance : (left wheel rotations * wheel circumference)
* turn to speed ratio : (the joystick values essentially)
* arc radius : (1 / (((outer wheel speed / inner wheel speed) - 1) / robot width)) not sure if it is very useful but we have it.

### THE THINGS WE NEED TO KNOW
Either... x and y coordinates
or... angle and distance polar coordinates
Useful links:
[http://rossum.sourceforge.net/papers/DiffSteer/](http://rossum.sourceforge.net/papers/DiffSteer/)
[http://www.seattlerobotics.org/encoder/200010/dead_reckoning_article.html](http://www.seattlerobotics.org/encoder/200010/dead_reckoning_article.html)

### ONCE WE HAVE AN X AND Y WE CAN IMPLEMENT LOTS OF THIS. ONE BEING IMPLEMENT DRIVE TO DISTANCE.

This one we can do without the position. It would be nice to wait however because we can more closely track position. (or at least easier.)

### DRIVE TO ANGLE

This one will require polar coordinates and what not. Something to note about this method and drive to distance is that they should be able to run asynchronous to each other. This could be done through some sort of state system / command and queue system or just running

through new threads. If there is time a command system would probably be easier in the future but multi-threading might** be a quick and dirty implementation.

  ** Note that I'm not sure how smooth threading goes in Java. When looking into it new Thread(() -> { DriveToAngle(angle) }).start()    seemed to work. That said I have not tested this.

The reason for asynchronous (or something similar) would be because of a loop that would probably run in the method to continually read and check if the angle is correct. Obviously if another solution is used then this will not be necessary but unless I'm missing something obvious, some sort of continuous read/write to the wheels will be necessary.
