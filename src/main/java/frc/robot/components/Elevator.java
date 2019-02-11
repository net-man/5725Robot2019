package frc.robot.components;

import edu.wpi.first.wpilibj.*;
import frc.robot.RobotMap;

public class Elevator {
    private Spark motor1 = new Spark(RobotMap.ELEVATOR_MOTOR_LIFT_1);
    // FIXME: Define encoder. I don't do this because WPILIB get's mad if one tries defining a component that already has a port.
    private Encoder encoder;

    public void Lift(double amount) {
        motor1.set(amount);
    }

    public double GetPosition() {
        // TODO: Implement get position.

        // TODO: Consider better naming then 'Position'.
        // Position is fine but I feel like there could be a more clear descriptor.
        return Double.NaN;
    }

    public void SetPosition(double value) {
        // TODO: Implement set position.
        
        // TODO: Again, think about possible better names.
    }

    public void ToggleSafty(boolean isSafe) {
        motor1.setSafetyEnabled(isSafe);
    }

    public void Stop() {
        motor1.stopMotor();
    }
}