package frc.robot.components;

import edu.wpi.first.wpilibj.*;
import frc.robot.extra.settings.RobotSettings;
import frc.utils.RobotMath;

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
     * The robots base speed. This will affect the speed of all user-controlled
     * inputs.
     * <p>
     * Autonomous speeds are controlled seperataly.
     */
    public double speed;
    public double speedUp;
    public double speedDown;

    /**
     * Initialize arm values.
     */
    public Arm() { load(); }

    /**
     * Loads new {@link ArmSettings} into the arm. This should be used
     * with {@link JSONSettings} to dynamically change the robots settings without
     * having to recompile code.
     * 
     * @param settings The Desired {@link ArmSettings} to load into the
     *                 arm.
     */
    public void load() {
        speed = RobotSettings.armSpeed;
        speedUp = RobotSettings.armSpeedUpRotation;
        speedDown = RobotSettings.armSpeedDownRotation;

        motor = new Spark(RobotSettings.portArmMotor);
    }

    /**
     * Frees all ports that were being used along with unloading / reseting anything else that requires it.
     */
    public void unload() {
        motor.close();
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
        // Lift or drop elevator
        if(amount > 0) {
            amount *= speedUp;
        }
        else if(amount < 0) {
            amount *= speedDown;
        }
        else {
            amount = 0;
        }

        System.out.println("Elevator = " + amount);

        amount = RobotMath.Clamp(amount, -speed, speed);
        motor.set(amount);
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