package frc.robot.components;

import edu.wpi.first.wpilibj.*;
import frc.robot.RobotMap;

public class DriveTrain {
    public Spark motorRight1 = new Spark(RobotMap.DRIVE_TRAIN_MOTOR_RIGHT_1.port);
    public Spark motorRight2 = new Spark(RobotMap.DRIVE_TRAIN_MOTOR_RIGHT_2.port);
    public Spark motorLeft1 = new Spark(RobotMap.DRIVE_TRAIN_MOTOR_LEFT_1.port);
    public Spark motorLeft2 = new Spark(RobotMap.DRIVE_TRAIN_MOTOR_LEFT_2.port);

    public void Drive(double rotation, double speed) {
        DriveTank(speed + rotation, speed - rotation);
    }

    public void DriveTank(double right, double left) {
        motorRight1.set(right);
        motorRight1.set(right);
        motorLeft1.set(left);
        motorLeft2.set(left);
    }

    public void ToggleSafty(boolean isSafe) {
        motorRight1.setSafetyEnabled(isSafe);
        motorRight1.setSafetyEnabled(isSafe);
        motorLeft1.setSafetyEnabled(isSafe);
        motorLeft2.setSafetyEnabled(isSafe);
    }

    public void Stop() {
        motorRight1.stopMotor();
        motorRight2.stopMotor();
        motorLeft1.stopMotor();
        motorLeft2.stopMotor();
    }
}