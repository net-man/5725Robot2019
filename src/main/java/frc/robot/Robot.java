package frc.robot;

import frc.robot.components.*;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends TimedRobot {
	public static DriveTrain driveTrain = new DriveTrain();
	// public static Elevator elevator = new Elevator();
	// public static Claw claw = new Claw();
	public static Controller controller = new Controller();


	// TODO: Delete me.
	// This is a test encoder that should be deleted once finished testing.
	public static Encoder motorEncoder = new Encoder(4, 5);

	public Robot() {
	}

	@Override
	public void robotInit() {
		System.out.println("****** Robot Code Initializing ******");
	}

	@Override
	public void robotPeriodic() {
		// Robot periodic is a bit strange in that it constantly runs throughout the life of the robot.
		// In other words it doesn't matter if it's autonomousPeriodic, disabledPeriodic, or whatever.
		// It will still run before calling those.

		// This should probably be tested if you want to use this method however because I may be wrong about this.
	}

	// Autonomous code...

	@Override
	public void autonomousInit() {
		System.out.println("****** Robot Autonomous Code Initializing ******");
		
		// This is throw-away test code.
		// Delete it once it get's in the way.
		// Also be careful when/if running it... I'm not sure if it will end that well.
		driveTrain.ToggleSafty(false);
		driveTrain.Drive(0.0, 1.0);

		Timer.delay(1.0);

		driveTrain.Stop();
		driveTrain.ToggleSafty(true);
	}

	@Override
	public void autonomousPeriodic() {
		// TODO: Addd CommandQueue.Periodic here.
		// To achive this, adding a CommandQueue class to Robot.java might help.
	}

	// Teleop Code...

	@Override
	public void teleopInit() {
		System.out.println("****** Robot Teleop Code Initializing ******");
	}

	@Override
	public void teleopPeriodic() {
		// TODO: Review.

		driveTrain.Drive(controller.GetX(), controller.GetY());
		System.out.println("Controller X: " + controller.x + "Y: " + controller.y);
	}


	// Disabled code...

	@Override
	public void disabledInit() {
		System.out.println("****** Robot Disabled Code Initializing ******");
	}

	@Override
	public void disabledPeriodic() {
	}

	// Test code...

	@Override
	public void testInit() {
		System.out.println("****** Robot Test Code Initializing ******");
	}

	@Override
	public void testPeriodic() {
		// Delete this when testing with the encoder is done.
		System.out.println("Encoder Count = " + motorEncoder.get() + " | Encoder Rate = " + motorEncoder.getRate() + " | Encoder Raw = " + motorEncoder.getRaw());
	}
}
