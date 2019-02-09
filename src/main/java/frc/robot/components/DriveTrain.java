package frc.robot.components;

import frc.utils.*;

import edu.wpi.first.wpilibj.*;
import frc.robot.RobotMap;

public class DriveTrain {
    // Some things to note.
    // 'Drive' will add onto the thing.
    // 'DriveTo' will set the thing to a specific value.
    // For example 'DriveDistance(x)' will drive forwards by x amount.
    // 'DriveToDistance(x)' will drive to x as distance of the robot's polar coordinates.

    private Spark motorRight1 = new Spark(RobotMap.DRIVE_TRAIN_MOTOR_RIGHT_1);
    private Spark motorRight2 = new Spark(RobotMap.DRIVE_TRAIN_MOTOR_RIGHT_2);
    private Spark motorLeft1 = new Spark(RobotMap.DRIVE_TRAIN_MOTOR_LEFT_1);
    private Spark motorLeft2 = new Spark(RobotMap.DRIVE_TRAIN_MOTOR_LEFT_2);

    // private Encoder encoderRight = new Encoder(0, 1);
    // private Encoder encoderLeft = new Encoder(0, 1);
    private Encoder encoderRight;
    private Encoder encoderLeft;

    private double distance;
    private double angle;

    public double driveSpeed = 0.4;
    public double turnSpeed = 0.2;

    public DriveTrain() {
    }

    public double GetWorldX() {
        // TODO: Test and debug.
        return Math.sin(angle) * distance;
    }
    public double GetWorldY() {
        // TODO: Test and debug.
        return Math.cos(angle) * distance;
    }

    // Set the distance of the robot from it's current position.
    public void DriveDistance(double cm, double speed) {
        // TODO: Test and debug.
        double d = distance + cm;
        while(Math.sqrt(distance*distance + d*d) > 1) {
            DriveTank(speed, speed);
        }
    }

    // Set the angle or rotation of the robot.
    public void DriveDegrees(double degrees, double speed) {
        double a = angle + degrees;
        // TODO: Test and debug.
        // FIXME: I don't think this if statement works.
        // What is should do is decide which way the bot is spinning based on what angle is desired.
        if(degrees < 0) speed *= -1;
        while(Math.sqrt(angle*angle + a*a) > 1) {
            DriveTank(speed, -speed);
        }
    }

    public void DriveToAngle(double angle) {
        // TODO: Implement.

        DriveTank(0, 0);
        System.out.println("Driving to angle.");
    }

    public void DriveToDistance(double distance) {
        // TODO: Implement.

        DriveTank(0, 0);
        System.out.println("Driving to distance.");
    }

    // Robot rotates and drives towards a given x and y.
    public void DriveToPoint(double x, double y) {
        // TODO: Test and debug.
        double d = Math.sqrt(x*x + y*y);
        double a = Math.atan(y / x);

        System.out.println("distance = " + d + "angle = " + a);

        // FIXME: Bad implementation.
        new Thread(() -> { DriveToAngle(a); }).start();
        // FIXME: Bad implementation.
        new Thread(() -> { DriveToDistance(d); }).start();
    }

    // Robot smoothly navigates a path.
    public void DriveToPointPath(Vector2[] points) {
        // TODO: Test and debug.
    }

    public void CalculateWorldPosition() {
        // TODO: Test and debug.
        // double right = encoderRight.getRate() * wheelCMCircumference;
        // double left = encoderLeft.getRate() * wheelCMCircumference;

        // double h = Math.sqrt(right*right + left*left);

        // if(left > right) speed = left;
        // else speed = right;

        // angle = Math.asin(speed/h);

        // position.Add(RobotMath.PolarToCartesian(speed, angle));
    }

    public void Drive(double rotation, double speed) {
        // FIXME: speed - rotation doesn't work as speed is still positive.
        rotation *= turnSpeed;
        DriveTank(speed + rotation, -(speed + rotation));
        System.out.println("Speed = " + speed + " | Rotation = " + rotation);
    }

    public void DriveTank(double right, double left) {
        right *= driveSpeed;
        left *= driveSpeed;
        motorRight1.set(right);
        motorRight2.set(right);
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