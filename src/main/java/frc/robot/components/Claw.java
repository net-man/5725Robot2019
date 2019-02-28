/* package frc.robot.components;

import edu.wpi.first.wpilibj.*;
import frc.robot.RobotMap;

Claw caught the big broke as of 2/19/19 so has been commented out for now - Raj

public class Claw {
    public Spark mainClaw = new Spark(RobotMap.CLAW_ROTATION_MOTOR_1);

    // FIXME: Define encoder. I don't do this because 
    // WPILIB get's mad if one tries defining a component that already has a port.
    private Encoder encoder;

    // this is just a test
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
        mainClaw.set(value);
    }

    public void ToggleSafty(boolean isSafe) {
        mainClaw.setSafetyEnabled(isSafe);
    }

    public void Stop() {
        mainClaw.stopMotor();
    }
}
    */
