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

	public static Encoder encoderTest = new Encoder(0, 0);

	public Robot() {
	}

	@Override
	public void robotInit() {
		System.out.println("****** Robot Code Initializing ******");
	}

	// Autonomous code...

	@Override
	public void autonomousInit() {
		System.out.println("****** Robot Autonomous Code Initializing ******");

		driveTrain.ToggleSafty(false);
		driveTrain.Drive(0.0, 1.0);

		Timer.delay(1.0);

		driveTrain.Stop();
		driveTrain.ToggleSafty(true);
	}

	@Override
	public void autonomousPeriodic() {
	}

	// Teleop Code...

	@Override
	public void teleopInit() {
		System.out.println("****** Robot Teleop Code Initializing ******");
	}

	@Override
	public void teleopPeriodic() {
		// TODO: Review.
		// Update the controller with new values. This was chosen for performance
		// over individual method calls. (i.e. GetX(), GetY()).
		// Consider re-thinking this as it in a great performace hit at all
		// and can't be overlooked by accident.
		controller.Update();
		// Drive the robot by the x and y joystick position.
		// Speed is controlled by the DriveTrain.
		driveTrain.Drive(controller.x, controller.y);
		
		// TODO: Consider making a custom console logger.

		// This is just a hacky solution for console spam. This will only print
		// Every 10000 ticks.
		if(tick % 10000 == 0) {
			System.out.println("Controller X: " + controller.x + "Y: " + controller.y);
		}
		tick++;
	}

	// Delete me once printing control x and y is no longer needed.
	int tick = 0;

	// Disabled code...

	@Override
	public void disabledInit() {
		System.out.println("****** Robot Disabled Code Initializing ******");
	}

	@Override
	public void disabledPeriodic() {
		System.out.println("****** Robot Disabled Code Looping ******");
	}

	// Test code...

	@Override
	public void testInit() {
		System.out.println("****** Robot Test Code Initializing ******");
	}

	@Override
	public void testPeriodic() {
		System.out.println("Encoder Count = " + encoderTest.get());
	}
}
