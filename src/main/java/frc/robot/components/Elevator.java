package frc.robot.components;

import edu.wpi.first.wpilibj.*;
import frc.robot.RobotMap;

public class Elevator {
    public Spark motor1 = new Spark(RobotMap.ELEVATOR_MOTOR_LIFT_1.port);

    public void Lift(double amount) {
        motor1.set(amount);
    }

    public void ToggleSafty(boolean isSafe) {
        motor1.setSafetyEnabled(isSafe);
    }

    public void Stop() {
        motor1.stopMotor();
    }
}