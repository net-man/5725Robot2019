package frc.robot.components;

import edu.wpi.first.wpilibj.*;
import frc.robot.RobotMap;

public class Elevator {
    private Spark motor1 = new Spark(RobotMap.ELEVATOR_MOTOR_LIFT_1);
    // FIXME: Define encoder. I don't do this because 
    // WPILIB get's mad if one tries defining a component that already has a port.
    private Encoder encoder;

    public void Lift(double amount) {
        motor1.set(amount);
    }

    public double GetPosition() {
        return motor1.getPosition();
    }

    public void SetPosition(double value) {
        motor1.setPosition(value);
    }

    public void ToggleSafty(boolean isSafe) {
        motor1.setSafetyEnabled(isSafe);
    }

    public void Stop() {
        motor1.stopMotor();
    }
}