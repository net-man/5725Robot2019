package frc.robot.components;

import edu.wpi.first.wpilibj.*;
import frc.robot.extra.settings.RobotSettings;
import frc.utils.RobotMath;

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
     * The robots base speed. This will affect the speed of all user-controlled
     * inputs.
     * <p>
     * Autonomous speeds are controlled seperataly.
     */
    public double speed;
    public double speedOpen;
    public double speedClose;

    public double SpeedConstantClampForce;

    public boolean isConstantClampEnabled = false;
    public boolean isClampping = false;

    /**
     * Initialize the claw's values.
     */
    public Claw() { load(); }

    /**
     * Loads new {@link ClawSettings} into the claw. This should be used with
     * {@link JSONSettings} to dynamically change the robots settings without having
     * to recompile code.
     * 
     * @param settings The Desired {@link ClawSettings} to load into the claw.
     */
    public void load() {
        speed = RobotSettings.clawSpeed;
        speedOpen = RobotSettings.clawSpeedOpen;
        speedClose = RobotSettings.clawSpeedClose;

        SpeedConstantClampForce = RobotSettings.clawSpeedConstantClampForce;
        isConstantClampEnabled = RobotSettings.clawIsConstantClampForceEnabled;

        motor = new Spark(RobotSettings.portClawMotor);
    }
    
    /**
     * Frees all ports that were being used along with unloading / reseting anything else that requires it.
     */
    public void unload() {
        motor.close();
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
        if(amount > 0) {
            amount *= speedOpen;

            // if(isConstantClampEnabled) {
            //     isClampping = true;
            // }
        }
        else if(amount < 0) {
            amount *= speedClose;

            // if(isConstantClampEnabled) {
            //     isClampping = false;
            // }
        }
        else {
            amount = 0;

            // if(isConstantClampEnabled) {
            //     amount = SpeedConstantClampForce;
            // }
        }
        motor.set(RobotMath.Clamp(amount, -speed, speed));
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
