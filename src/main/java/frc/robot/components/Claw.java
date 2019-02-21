package frc.robot.components;

import edu.wpi.first.wpilibj.*;
import frc.robot.extra.settings.ClawSettings;

/**
 * Robot claw component. This class represents a generic claw-like structure
 * with a rotating axis opening and closing it.
 */
public class Claw {
    /**
     * The claw motor. the motors rotation will determine how open or closed the
     * claw is.
     */
    private Spark motor;

    /**
     * The claw encoder. This is used to get the current position of the claw. From
     * this, exact claw positions can be set based on what is needed.
     * <p>
     * This is optional. To disable it, set {@link ClawSettings#isEncoderEnabled} to
     * false.
     */
    private Encoder encoder;

    /**
     * The claw settings for this claw. This will affect things like speed and
     * encoder direction.
     */
    private ClawSettings settings;

    /**
     * The robots base speed. This will affect the speed of all user-controlled
     * inputs.
     * <p>
     * Autonomous speeds are controlled seperataly.
     */
    public double speed;

    /**
     * The total amount of times the claw motor has done a full rotation.
     */
    public int encoderCount;

    /**
     * The amount of cm's the claw moves in one motor rotation.
     */
    public double distancePerRevolution;

    /**
     * Initialize the claw's values.
     */
    public Claw() { load(new ClawSettings()); }

    /**
     * Loads new {@link ClawSettings} into the claw. This should be used with
     * {@link JSONSettings} to dynamically change the robots settings without having
     * to recompile code.
     * 
     * @param settings The Desired {@link ClawSettings} to load into the claw.
     */
    public void load(ClawSettings settings) {
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
     * Rotates the claw motor by a speed value.
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
     * Get's the claws current position. This values comes from the motor encoder
     * value difference.
     * <p>
     * This means that if the direction is changed between calls of this method, the
     * position will be off.
     * 
     * @return The double position of the claw in centimeters.
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
     * Toggles the claw motor's safety.Safety sets the motors speed to zero every
     * update so the robot doesn't continue to drive, even when control is turned
     * off.
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
     * Stops all motors from spinning.
     */
    public void stop() {
        motor.stopMotor();
    }
}