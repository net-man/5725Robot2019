package frc.robot.components;

import edu.wpi.first.wpilibj.*;
import frc.robot.extra.settings.RobotSettings;
import frc.utils.RobotMath;

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

    private DigitalInput switchTop;
    private DigitalInput switchBottom;

    /**
     * The robots base speed. This will affect the speed of all user-controlled
     * inputs.
     * <p>
     * Autonomous speeds are controlled seperataly.
     */
    public double speed;
    public double speedAscending;
    public double speedDescending;

    public boolean canDescend = true;
    public boolean canAscend = true;

    /**
     * Initialize elevator values.
     */
    public Elevator() { load(); }

    /**
     * Loads new {@link ElevatorSettings} into the elevator. This should be used with
     * {@link JSONSettings} to dynamically change the robots settings without having
     * to recompile code.
     * 
     * @param settings The Desired {@link ElevatorSettings} to load into the elevator.
     */
    public void load() {
        speed = RobotSettings.elevatorSpeed;
        speedAscending = RobotSettings.elevatorSpeedAscending;
        speedDescending = RobotSettings.elevatorSpeedDescending;

        motor = new Spark(RobotSettings.portElevatorMotor);
        switchTop = new DigitalInput(RobotSettings.dportElevatorSwitchTop);
        switchBottom = new DigitalInput(RobotSettings.dportElevatorSwitchBottom);
    }

    /**
     * Frees all ports that were being used along with unloading / reseting anything else that requires it.
     */
    public void unload() {
        motor.close();
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
        // Update canAscend / canDescend
        if(switchBottom.get() == true) {
            canDescend = false;
        }
        else {
            canDescend = true;
        }
        if(switchTop.get() == true) {
            canAscend = false;
        }
        else {
            canAscend = true;
        }

        // Lift or drop elevator
        if(canAscend == true && amount > 0) {
            amount *= speedAscending;
        }
        else if(canDescend == true && amount < 0) {
            amount *= speedDescending;
        }
        else {
            amount = 0;
        }

        System.out.println("Elevator = " + amount);

        amount = RobotMath.Clamp(amount, -speed, speed);
        motor.set(amount);
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