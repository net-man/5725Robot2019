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

### Drive to point. This is where I think things get quite interesting if we do get to the point.

This will require one of two approaches. One easy, one hard.

1. Sequence setting angle and setting distance. Basically, the robot would never be able to do both turning and driving forwards at the same time because this would mess with things. At first I though it wouldn't but after some though I'm pretty sure** it will mess with at least something.

** Thinking more on this, it wouldn't mess with calculating position in theory, setting both angle and distance at the same time seems like it may be possible but I really haven't got a clue.

2. More calculations to figure out this. Luckily, this doesn't seem terribly hard has would have already solved getting position.

### Drive to point array. This is just following a path. It will be quite helpful when working with pathfinding.

Essentially, each grid space could be a point in the array so the the robot would drive along the path-grid spaces. If we could somehow optimize points so the robot doesn't try to drive through each of the points perfectly that would also be good.

example: if the next point is only a few degrees of current point, look a next point. repeat.

### Elevator + Arm

I'm putting these two in the same group because they are pretty much the same in terms of code.

### Set/Get motor encoder position. This should be pretty simple to solve for each mechanism revolutions per cm * revolutions.

for a pulley system this would be the circumference of the wheel pulling the chain / cable / whatever.
The arm also be something. Not sure what but it doesn't seem like a bit issue anyhow.

### Claw

For the claw I hope I am right in saying that it only has two states. open / close.

### ~AUTONOMOUS~

If you end up getting to pathfinding and what not I would suggest possibly trying to contact me as I will have a bit of communication (probably).

I say this because I have kind of left pathfinding in a horrible mess. If you do decide to tackle pathfinding I will try my best to provide some help with cleaning up the mess I have made.

  The Github has a "GridMaker" program that should be able to create grids and save out the info. That said I haven't implemented saving the grid nodes (the most important part). Adding this shouldn't be too difficult luckily but it is in a different language (C#) and in a horrible state so tread lightly.

Once you find the saving code (in ProgramWindow.cs -> Program.onExit),

you need to first enable it and debug it if necessary.

Then add something like Program.data.service["nodes"] = grid.pixels

First you will need to make pixels visible in PathfindingGrid.cs -> long[,] pixels

Doing that should output a json file with a few variables followed by a 2d array of Int64.

The 2d array of Int64 act as "walls" of sorts that the pathfinding can't go through. This is represented in binary however so 0 would be passable and 1 would be impassible.

2. If you make it past that, next will be reading the json export file in the robot program. (Java) The only important varibles I think are:

    'unit' - the cms per nodes of the grid.

    'pixels[,]' - the grid itself.

To read the json file I think there is already the gson library I installed in the gradle.build.

Using the simple user set up instructions of gson should head you down the right path to easily extract all variables needed.

3. After that you should have:

A grid of bits acting as walls in the pathfinding.

A method of going from grid units to cms.

From the "GridMaker" program there should be a pathfinding algorithm that can be imported (or just extensively debug the java solution.)

For getting and setting individual bits there is also solutions in the "GridMaker" program under PathfindingGrid -> SetPixel() and GetPixel()

After all of that you should have:

A grid of bits in Int64 form.
A grid of floats OR calculationNodes (depending on which version of pathfinding: Java or C#).
A Pathfinding solution that solves this grid.

That's a lot of stuff.

4. Finally, there is robot control

If you ended up getting 'DriveToPoint' or 'DriveToPoints' working, this should be no problem.

Even if you haven't, it still should be pretty easy.

The special bit of this is that as long as we continue to track the robot position, we could drive to anywhere on the field, whenever, totally autonomously. This includes auto-alignment which I think would be pretty helpful.

If anyone actually ends up doing this, first of all: sorry. Second, that's quite impressive, good job.

### Camera Code

I really don't have anything on this. Luckily, I don't believe it to be terribly hard to implement but it has been a while.

Sorry if it's something extremely hard to do and I have just left it until (almost) last.

### Nice to have Things

There is a lot of small things that can be done if there is nothing else to be worked on or fighting with autonomous just seems like to much of a bother.

#### JSON settings. This seems complicated but should be rather easy. I do believe I have implemented quite bit of this already.

For this, I am using Gson which has some good documentation that you could read through or you could just look at what I already have. It's a fairly simple library to use and isn't hard to understand

#### Proper code commenting. If Json settings seem like a bad idea, there is always comments to add to code. 

This will boost readability of the code. I should have done this at the start but have been too lazy to. For that I apologize.

#### Proper code naming. This is also code cleanup but I think it may be necessary.

Most methods and classes I feel make sense but there are probably things that could be done better.

#### Optimization

There aren't too many things that could be optimized besides pathfinding but looking around never hurts.

### Things For Fun

If (somehow) there is literally nothing to do, there are a few things that may be interesting to work of if anyone is so inclined.

#### 1. Custom Logging.

This could be useful for debug specific things if there was a log flagging system, color coding, etc.
read up on ascii escape codes

#### 2. WPILIB wifi table communication.

This could be neat for getting and drawing the robots position on a grid or why not. This could also be used for off-loading things from the robot to the drive station.

### Conclusion

I don't doubt there at least 20 things I have missed but so far this has been what I have been working on. (Or at least minus the last two sections.)

A few notes to end on:

If there are questions for me from getting confused with the mess of a document to some question on odd code implementations, I should be able to communicate via slack at least some of the time.
