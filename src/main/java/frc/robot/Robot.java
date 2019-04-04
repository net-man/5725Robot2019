package frc.robot;

import frc.robot.autonomous.CommandQueue;
import frc.robot.components.*;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
	public static DriveTrain driveTrain = new DriveTrain();
	public static Elevator elevator = new Elevator();
	public static Arm arm = new Arm();
	public static Claw claw = new Claw();

	public static Controller controller = new Controller();

	public static CommandQueue commandQueue = new CommandQueue();

	@Override
	public void robotInit() {
		System.out.println("****** Robot Code Initializing ******");
		CameraServer.getInstance().startAutomaticCapture();

		// driveTrain.drive(1, 1);
		// driveTrain.drive(-1, 1);
		// driveTrain.drive(1, -1);
		// driveTrain.drive(0, 0);
		// driveTrain.drive(-1, -1);
		// driveTrain.drive(0.5, 1);
		// edu.wpi.first.wpilibj.CameraServer.getInstance().startAutomaticCapture();

		// driveTrain.unload();
		// elevator.unload();
		// arm.unload();
		// claw.unload();

		// RobotSettings settings = (RobotSettings) JSONSettings.DeSerialize("Settings", RobotSettings.class);
		// if (settings == null) {
		// 	JSONSettings.Serialize("settings", new RobotSettings());
		// 	settings = (RobotSettings) JSONSettings.DeSerialize("Settings", RobotSettings.class);
		// }

		// driveTrain.load(settings.driveTrain);
		// elevator.load(settings.elevator);
		// arm.load(settings.arm);
		// claw.load(settings.claw);

		// System.out.println("Elevator Speed: " + elevator.speed);
		// System.out.println("Arm Speed: " + arm.speed);
	}
 
	@Override
	public void robotPeriodic() {
		// Robot periodic is a bit strange in that it constantly runs throughout the
		// life of the robot.
		// In other words it doesn't matter if it's autonomousPeriodic,
		// disabledPeriodic, or whatever.
		// It will still run before calling those.

		// This should probably be tested if you want to use this method however because
		// I may be wrong about this.
	}

	// Autonomous code...
	@Override
	public void autonomousInit() {
		System.out.println("****** Robot Autonomous Code Initializing ******");

		// Use 'commandQueue.commands.add(COMMAND)

		// This is throw-away test code.
		// Delete it once it get's in the way.
		// Also be careful when/if running it... I'm not sure if it will end that well.

		// driveTrain.toggleSafty(false);
		// driveTrain.drive(0.0, 1.0);

		// Timer.delay(1.0);

		// driveTrain.stop();
		// driveTrain.toggleSafty(true);
	}

	@Override
	public void autonomousPeriodic() {
		commandQueue.Periodic();
		
		driveTrain.drive(controller.GetX(), controller.GetY());
		claw.rotate(controller.GetRightTrigger() - controller.GetLeftTrigger());
		arm.rotate(controller.GetRightY());
		elevator.lift(controller.DPad());
	}

	// Teleop Code...

	@Override
	public void teleopInit() {
		System.out.println("****** Robot Teleop Code Initializing ******");
	}

	@Override
	public void teleopPeriodic() {
		driveTrain.drive(controller.GetX(), controller.GetY());
		claw.rotate(controller.GetRightTrigger() - controller.GetLeftTrigger());
		arm.rotate(controller.GetRightY());
		elevator.lift(controller.DPad());

		System.out.println("Can Ascend = " + elevator.canAscend);
		System.out.println("Can Decend = " + elevator.canDescend);
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
		driveTrain.drive(controller.GetX(), controller.GetY());
		// driveTrain.driveTank(controller.GetX(), -controller.GetX());
		elevator.lift(controller.GetRightTrigger() - controller.GetLeftTrigger());
		arm.rotate(-controller.GetRightY());
		claw.rotate(controller.GetRightButtonTrigger() - controller.GetLeftButtonTrigger());

		// System.out.println("DriveTrain X = " + controller.GetX() + " | Y = " + controller.GetY());
		// System.out.print("Arm = " + (controller.GetRightY()) + "   ");
		// System.out.print("Lift = " + (controller.GetRightTrigger() - controller.GetLeftTrigger()) + "   ");
		// System.out.println("Claw = " + (controller.GetRightButtonTrigger() - controller.GetLeftButtonTrigger()));
		// System.out.println("Switch = " + switchController.get());
	}
}
