package frc.robot.components;

import frc.utils.*;

import edu.wpi.first.wpilibj.*;
import frc.robot.extra.settings.*;

/**
 * Robot drive train component. This class represent the driving base of the
 * robot and is how the robot moves around.
 * <p>
 * The movement is setup with two motors on each side controlling one gear on
 * each side. (two motors = more force) both sides moving will generate speed
 * and the difference in side speeds will generate rotation.
 */
public class DriveTrain {
    /**
     * The first right motor.
     */
    private Spark motorRight1;

    /**
     * The second right motor.
     */
    private Spark motorRight2;

    /**
     * The first left motor.
     */
    private Spark motorLeft1;

    /**
     * The second left motor.
     */
    private Spark motorLeft2;

    /**
     * The drive train drive speed. This will affect the speed of all
     * user-controlled inputs.
     * <p>
     * Autonomous speeds are controlled seperataly.
     */
    public double driveSpeed;

    /**
     * The drive train turn speed. This will affect the speed of all user-controlled
     * inputs.
     * <p>
     * Autonomous speeds are controlled seperataly.
     */
    public double turnSpeed;

    /**
     * The maximum speed magnitude the robot can move.
     */

    public double speed;

    public double rightSpeed;
    public double leftSpeed;

    /**
     * If set to true, the drive value will be normalized as if the value was a
     * circle of sorts.
     */
    public boolean isDriveSquared;
    public boolean isDriveSnapped;

    public double[] snapValuesX;
    public double[] snapValuesY;

    public boolean isRightInversed;
    public boolean isLeftInversed;

    /**
     * Initialize drive train values.
     */
    public DriveTrain() {
        load();
    }

    /**
     * Loads new {@link DriveTrainSettings} into the drive train. This should be
     * used with {@link JSONSettings} to dynamically change the robots settings
     * without having to recompile code.
     * 
     * @param settings The Desired {@link DriveTrainSettings} to load into the drive
     *                 train.
     */
    public void load() {
        speed = RobotSettings.driveTrainSpeed;
        driveSpeed = RobotSettings.driveTrainDriveSpeed;
        turnSpeed = RobotSettings.driveTrainTurnSpeed;

        rightSpeed = RobotSettings.driveTrainRightSpeed;
        leftSpeed = RobotSettings.driveTrainLeftSpeed;

        isDriveSquared = RobotSettings.driveTrainIsDriveSquared;
        isDriveSnapped = RobotSettings.driveTrainIsDriveSnapped;

        snapValuesX = RobotSettings.driveTrainSnapValuesX;
        snapValuesY = RobotSettings.driveTrainSnapValuesY;

        motorRight1 = new Spark(RobotSettings.portDriveTrainMotorRight1);
        motorRight2 = new Spark(RobotSettings.portDriveTrainMotorRight2);
        motorLeft1 = new Spark(RobotSettings.portDriveTrainMotorLeft1);
        motorLeft2 = new Spark(RobotSettings.portDriveTrainMotorLeft2);

        motorRight1.setInverted(isRightInversed);
        motorRight2.setInverted(isRightInversed);
        motorLeft1.setInverted(isLeftInversed);
        motorLeft2.setInverted(isLeftInversed);
    }

    /**
     * Frees all ports that were being used along with unloading / reseting anything
     * else that requires it.
     */
    public void unload() {
        motorRight1.close();
        motorRight2.close();
        motorLeft1.close();
        motorLeft2.close();
    }

    /**
     * Moves the drive train by rotation and distance speed.
     * <p>
     * This method is affected by {@link #driveSpeed} and {@link #turnSpeed}.
     * 
     * @param rotation The rotation speed the robot should drive. Between -1 and 1.
     * @param speed    The distance speed the robot should drive. Between -1 and 1.
     */
    public void drive(double rotation, double speed) {
        rotation *= turnSpeed;
        speed *= -driveSpeed;
        if(Math.abs(rotation) < 0.08) rotation = 0.0f;
        if(Math.abs(speed) < 0.08) speed = 0.0f;

        if (isDriveSquared == true) {
            // If is squared set to true, square speed and rotation.
            // Figures out negative if lossed in calculation.
            double temp = speed*speed;
            speed = speed < 0 ? -temp : temp;

            temp = rotation*rotation;
            rotation = rotation < 0 ? -temp : temp;
        }

        // System.out.print("Speed = " + speed + " | " + "Rotation = " + rotation + "  >>> ");

        if(isDriveSnapped == true) {
            speed = RobotMath.Snap(speed, snapValuesY, 0.1);
            rotation = RobotMath.Snap(rotation, snapValuesX, 0.1);
        }

        // System.out.println("Speed = " + speed + " | " + "Rotation = " + rotation);

        double right = speed + rotation;
        double left = speed - rotation;

        driveTank(right, left);
    }

    /**
     * Moves the drive train by right speed and left speed.
     * <p>
     * This method is affected by {@link #driveSpeed} and {@link #turnSpeed}.
     * 
     * @param right The right side speed the drive train should drive. Between -1
     *              and 1.
     * @param left  The left side speed the drive train should drive. Between -1 and
     *              1.
     */
    public void driveTank(double right, double left) {
        right = RobotMath.Clamp(right, -speed, speed) * rightSpeed;
        left = RobotMath.Clamp(left, -speed, speed) * leftSpeed;

        motorRight1.set(right);
        motorRight2.set(right);
        motorLeft1.set(-left);
        motorLeft2.set(-left);
    }

    /**
     * Get's the drive trains current position. This values comes from the motor
     * encoder value difference.
     * <p>
     * This means that if the direction is changed between calls of this method, the
     * position will be off.
     * 
     * @return The x abd y position of the drive train in centimeters.
     */
    public Vector2 GetPosition() {
        // Links for research:
        // http://rossum.sourceforge.net/papers/DiffSteer/
        // http://www.seattlerobotics.org/encoder/200010/dead_reckoning_article.html

        // Calculation:
        // expr1 = AXLE_LENGTH * (right + left)
        // position.x += expr1 * (sin((right - left) / AXLE_LENGTH + position.theta) -
        // sin_current)
        // position.y -= expr1 * (cos((right - left) / AXLE_LENGTH + position.theta) -
        // cos_current)
        // position.theta += (right - left) / AXLE_LENGTH
        return new Vector2();
    }

    /**
     * Toggles the driveTrain motor's safety.Safety sets the motors speed to zero
     * every update so the robot doesn't continue to drive, even when control is
     * turned off.
     * <p>
     * Turning this off is good for autnomous in conjunction with
     * {@code Timer.delay(time)}.
     * 
     * @param isSafe If set to true, the motors will be set to zero every update. If
     *               set to false, they will continue to spin at the previous speed
     *               until a new speed is set.
     */
    public void toggleSafty(boolean isSafe) {
        motorRight1.setSafetyEnabled(isSafe);
        motorRight1.setSafetyEnabled(isSafe);
        motorLeft1.setSafetyEnabled(isSafe);
        motorLeft2.setSafetyEnabled(isSafe);
    }

    /**
     * Stops all motors in drive train.
     */
    public void stop() {
        motorRight1.stopMotor();
        motorRight2.stopMotor();
        motorLeft1.stopMotor();
        motorLeft2.stopMotor();
    }
}