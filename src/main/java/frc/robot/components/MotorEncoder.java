package frc.robot.components;

import edu.wpi.first.wpilibj.Encoder;
import frc.robot.RobotMap;

/**
 * MotorEncoder
 */
public class MotorEncoder {

    public Encoder driveTrainEncoderLeft = new Encoder(RobotMap.DRIVE_TRAIN_MOTOR_LEFT_1, RobotMap.DRIVE_TRAIN_MOTOR_LEFT_2);
    public Encoder driveTrainEncoderRight = new Encoder(RobotMap.DRIVE_TRAIN_MOTOR_RIGHT_1, RobotMap.DRIVE_TRAIN_MOTOR_RIGHT_2);

    public Encoder elevatorrEncoder = new Encoder(RobotMap.ELEVATOR_MOTOR_ENCODER_1, RobotMap.ELEVATOR_MOTOR_ENCODER_2); 

    public MotorEncoder(){
        // TODO: make constructer
    }

    public int getRotationsLeft(){
        return driveTrainEncoderLeft.get();
    }

    public int getRotationsRight(){
        return driveTrainEncoderRight.get();
    }
}
