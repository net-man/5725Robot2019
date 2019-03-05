package frc.robot.components;

import edu.wpi.first.wpilibj.*;
import frc.robot.extra.settings.ArmSettings;

/**
 * Robot elevator component. This class represents a basic arm with z
 * rotation up and down.
 */
public class Arm {
    /**
     * The arm motor. the motors rotation will determine how rotated arm is
     * positioned.
     */
    private Spark motor;

    /**
     * The arm encoder. This is used to get the current position of the
     * arm. From this, exact arm positions can be set based on what is
     * needed.
     * <p>
     * This is optional. To disable it, set
     * {@link ElevatorSettings#isEncoderEnabled} to false.
     */
    private Encoder encoder;

    /**
     * The arm settings for this arm. This will affect things like speed
     * and encoder direction.
     */
    private ArmSettings settings;

    /**
     * The robots base speed. This will affect the speed of all user-controlled
     * inputs.
     * <p>
     * Autonomous speeds are controlled seperataly.
     */
    public double speed;

    /**
     * The total amount of times the arm motor has done a full rotation.
     */
    public int encoderCount;

    /**
     * The amount of cm's the arm moves in one motor rotation.
     */
    public double distancePerRevolution;

    /**
     * Initialize arm values.
     */
    public Arm() { load(new ArmSettings()); }

    /**
     * Loads new {@link ArmSettings} into the arm. This should be used
     * with {@link JSONSettings} to dynamically change the robots settings without
     * having to recompile code.
     * 
     * @param settings The Desired {@link ArmSettings} to load into the
     *                 arm.
     */
    public void load(ArmSettings settings) {
        this.settings = settings;

        speed = settings.speed;
        distancePerRevolution = settings.distancePerRevolution;

        motor = new Spark(settings.portMotor);

        if (settings.isEncoderEnabled) {
            encoder = new Encoder(settings.portEncoderA, settings.portEncoderB, settings.isEncoderReversed,
                    Encoder.EncodingType.k4X);
        }
    }

    /**
     * Moves the arm either up or down by a speed amount.
     * <p>
     * This method is affected by {@link #speed}.
     * 
     * @param amount The speed at which the motor should rotate. value should be
     *               between 1 and -1.
     */
    public void rotate(double amount) {
        motor.set(amount * speed);
    }

    /**
     * Get's the arm current position. This values comes from the motor
     * encoder value difference.
     * <p>
     * This means that if the direction is changed between calls of this method, the
     * position will be off.
     * 
     * @return The double position of the arm in centimeters.
     */
    public double getPosition() {
        if (encoderCount == 0) {
            encoderCount = encoder.get();
            return encoderCount;
        }

        int current = encoderCount - encoder.get();
        encoderCount = encoder.get();
        return current * distancePerRevolution;
    }

    /**
     * Toggles the arm motor's safety.Safety sets the motors speed to zero
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
        motor.setSafetyEnabled(isSafe);
    }

    /**
     * Stops all motors in {@link Arm} from spinning.
     */
    public void stop() {
        motor.stopMotor();
    }
}