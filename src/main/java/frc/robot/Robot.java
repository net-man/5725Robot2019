package frc.robot;

import frc.robot.components.*;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends TimedRobot {
	public static DriveTrain driveTrain = new DriveTrain();
	// public static Elevator elevator = new Elevator();
	// public static Claw claw = new Claw();
	public static Controller controller = new Controller();

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
		System.out.println("****** Robot Autonomous Code Looping ******");
	}

	// Teleop Code...

	@Override
	public void teleopInit() {
		System.out.println("****** Robot Teleop Code Initializing ******");
	}

	@Override
	public void teleopPeriodic() {
		// System.out.println("****** Robot Teleop Code Looping ******");

		controller.Update();
		driveTrain.Drive(controller.x * 0.3, controller.y * 0.3);
		// driveTrain.DriveTank(controller.x * 0.3, controller.x * 0.3);
		// driveTrain.DriveTank(controller.y * 0.3, 0);
		System.out.println("Controller X: " + controller.x + "Y: " + controller.y);
	}

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
		System.out.println("****** Robot Test Code Looping ******");
	}
}
