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

###ONCE WE HAVE AN X AND Y WE CAN IMPLEMENT LOTS OF THIS. ONE BEING IMPLEMENT DRIVE TO DISTANCE.
