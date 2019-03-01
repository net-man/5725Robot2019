package frc.robot;

import frc.robot.autonomous.CommandQueue;
import frc.robot.components.*;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends TimedRobot {
	public static DriveTrain driveTrain = new DriveTrain();
	public static Elevator elevator = new Elevator();
	public static Claw claw = new Claw();

	public static Controller controller = new Controller();

	public static CommandQueue commandQueue = new CommandQueue();

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
/* Honestly just yoss autonomous out the window for now - Raj
	@Override
	public void autonomousInit() {
		System.out.println("****** Robot Autonomous Code Initializing ******");
		
		//Use 'commandQueue.commands.add(COMMAND)

		// This is throw-away test code.
		// Delete it once it get's in the way.
		// Also be careful when/if running it... I'm not sure if it will end that well.
		driveTrain.toggleSafty(false);
		driveTrain.drive(0.0, 1.0);

		Timer.delay(1.0);

		driveTrain.stop();
		driveTrain.toggleSafty(true);
	}

	@Override
	public void autonomousPeriodic() {
		commandQueue.Periodic();
	}

	// Teleop Code...

	@Override
	public void teleopInit() {
		System.out.println("****** Robot Teleop Code Initializing ******");
	}

	@Override
	public void teleopPeriodic() {
		driveTrain.drive(controller.GetX(), controller.GetY());
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
		// I'm not quite sure which one gets rotations per update. Use wichever one does.
		// System.out.println("Encoder Count = " + MotorEncoder.driveTrainEncoderLeft.get() + " | Encoder Rate = " + MotorEncoder.driveTrainEncoderLeft.getRate() + " | Encoder Raw = " + MotorEncoder.driveTrainEncoderLeft.getRaw());
		// float rate = (float) MotorEncoder.driveTrainEncoderLeft.getRate();
		// float wheelCircumference = 2.0f;
		// float distance = rate * wheelCircumference;
		
		// System.out.println("Distance = " + distance);
		controller.joystickButton.get();
	}
	*/
}
