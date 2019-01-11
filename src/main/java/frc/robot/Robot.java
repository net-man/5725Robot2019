package frc.robot;

import frc.robot.components.*;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends SampleRobot {
  public static DriveTrain driveTrain = new DriveTrain();
  public static Elevator elevator = new Elevator();
  public static Claw claw = new Claw();
  public static Controller controller = new Controller();

  public Robot() { }

  @Override
  public void robotInit() {
    System.out.println("Robot Code Initializing");
  }

  @Override
  public void autonomous() {
    System.out.println("Robot Autonomous Code Executing");

    driveTrain.ToggleSafty(false);
    driveTrain.Drive(0.0, 1.0);

    Timer.delay(1.0);

    driveTrain.Stop();
    driveTrain.ToggleSafty(true);

    while(isAutonomous() && isEnabled()) {
    }
  }

  @Override
  public void operatorControl() {
    System.out.println("Robot Operator Code Executing");
    while (isOperatorControl() && isEnabled()) {
      controller.Update();

      driveTrain.Drive(controller.x, controller.y);
    }
  }

  @Override
  public void disabled() {
    System.out.println("Robot Disabled");
    while (isDisabled() && isEnabled()) {
    }
  }

  @Override
  public void test() {
    System.out.println("Robot Test Code Executing");
    while (isTest() && isEnabled()) {
    }
  }
}
