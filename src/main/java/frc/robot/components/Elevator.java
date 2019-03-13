package frc.robot.components;

import edu.wpi.first.wpilibj.*;
import frc.robot.extra.settings.ElevatorSettings;

/**
 * Robot elevator component. This class represents a basic elevator with y movement
 * up and down.
 */
public class Elevator {
    /**
     * The elevator motor. the motors rotation will determine how far up the
     * elevator is positioned.
     */
    private Spark motor;

    /**
     * The elevator encoder. This is used to get the current position of the elevator. From
     * this, exact elevator positions can be set based on what is needed.
     * <p>
     * This is optional. To disable it, set {@link ElevatorSettings#isEncoderEnabled} to
     * false.
     */
    private Encoder encoder;

    /**
     * The elevator settings for this elevator. This will affect things like speed and
     * encoder direction.
     */
    private ElevatorSettings settings;

    /**
     * The robots base speed. This will affect the speed of all user-controlled
     * inputs.
     * <p>
     * Autonomous speeds are controlled seperataly.
     */
    public double speed;

    /**
     * The total amount of times the elevator motor has done a full rotation.
     */
    public int encoderCount;

    /**
     * The amount of cm's the elevator moves in one motor rotation.
     */
    public double distancePerRevolution;

    /**
     * Initialize elevator values.
     */
    public Elevator() { load(new ElevatorSettings()); }

    /**
     * Loads new {@link ElevatorSettings} into the elevator. This should be used with
     * {@link JSONSettings} to dynamically change the robots settings without having
     * to recompile code.
     * 
     * @param settings The Desired {@link ElevatorSettings} to load into the elevator.
     */
    public void load(ElevatorSettings settings) {
        this.settings = settings;

        speed = settings.speed;
        distancePerRevolution = settings.distancePerRevolution;

        motor = new Spark(settings.portMotor);

        if (settings.isEncoderEnabled) {
            encoder = new Encoder(settings.portEncoderA, settings.portEncoderB, settings.isEncoderReversed, Encoder.EncodingType.k4X);
        }
    }

    /**
     * Frees all ports that were being used along with unloading / reseting anything else that requires it.
     */
    public void unload() {
        motor.close();
        if(encoder != null) encoder.close();
    }

    /**
     * Moves the elevator either up or down by a speed amount.
     * <p>
     * This method is affected by {@link #speed}.
     * 
     * @param amount The speed at which the motor should rotate. value should be
     *               between 1 and -1.
     */
    public void lift(double amount) {
        motor.set(amount * speed);
    }

    /**
     * Get's the elevators current position. This values comes from the motor encoder
     * value difference.
     * <p>
     * This means that if the direction is changed between calls of this method, the
     * position will be off.
     * 
     * @return The double position of the elevator in centimeters.
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
     * Toggles the elevator motor's safety.Safety sets the motors speed to zero every
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
     * Stops all motors in {@link Elevator} from spinning.
     */
    public void stop() {
        motor.stopMotor();
    }
}