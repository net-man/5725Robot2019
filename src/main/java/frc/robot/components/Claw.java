package frc.robot.components;

import edu.wpi.first.wpilibj.*;
import frc.robot.RobotMap;

public class Claw {
    public Spark motor1 = new Spark(RobotMap.CLAW_ROTATION_MOTOR_1.port);

    public void Rotate(double amount) {
        motor1.set(amount);
    }

    public void ToggleSafty(boolean isSafe) {
            motor1.setSafetyEnabled(isSafe);
    }

    public void Stop() {
        motor1.stopMotor();
    }
}