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

	public static Encoder motorEncoder = new Encoder(4, 5);

	public Robot() {
	}

	@Override
	public void robotInit() {
		System.out.println("****** Robot Code Initializing ******");
	}

	@Override
	public void robotPeriodic() {
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
		// System.out.println("****** Robot Teleop Code Looping ******");

		driveTrain.Drive(controller.GetX(), controller.GetY());
		System.out.println("Controller X: " + controller.x + "Y: " + controller.y);
	}

	// Disabled code...

	@Override
	public void disabledInit() {
		System.out.println("****** Robot Disabled Code Initializing ******");

		driveTrain.DriveToPoint(10, 4);
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
		System.out.println("Encoder Count = " + motorEncoder.get() + " | Encoder Rate = " + motorEncoder.getRate() + " | Encoder Raw = " motorEncoder.getRaw());
	}
}
