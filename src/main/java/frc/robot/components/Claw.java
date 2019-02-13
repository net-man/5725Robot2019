package frc.robot.components;

import edu.wpi.first.wpilibj.*;
import frc.robot.RobotMap;

public class Claw {
    public Spark mainClaw = new Spark(RobotMap.CLAW_ROTATION_MOTOR_1);

    // FIXME: Define encoder. I don't do this because 
    // WPILIB get's mad if one tries defining a component that already has a port.
    private Encoder encoder;

    public void Rotate(double amount) {
        mainClaw.set(amount);
    }
    
    public double GetPosition() {
        // TODO: Not the best implematation I think need to test.

        // TODO: Consider better naming then 'Position'.
        // Position is fine but I feel like there could be a more clear descriptor.

        return mainClaw.getPosition();
    }

    public void SetPosition(double value) {
        // TODO: Implement set position.
        // doest really set position but rather moves it
        mainClaw.setPosition(value);
    }

    public void ToggleSafty(boolean isSafe) {
        mainClaw.setSafetyEnabled(isSafe);
    }

    public void Stop() {
        mainClaw.stopMotor();
    }
}