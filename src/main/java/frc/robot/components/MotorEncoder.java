package frc.robot.components;

import edu.wpi.first.wpilibj.Encoder;
import frc.robot.RobotMap;

/**
 * MotorEncoder
 */
public class MotorEncoder {

    private Encoder driveTrainEncoder = new Encoder(RobotMap.DRIVE_TRAIN_MOTOR_LEFT_1, RobotMap.DRIVE_TRAIN_MOTOR_LEFT_2);

    public MotorEncoder(){
        // TODO: make constructer
    }

    public int getRotations(){
        return driveTrainEncoder.get();
    }
}