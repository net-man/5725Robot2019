package frc.robot.extra.settings;

import frc.utils.Vector2;

public class DriveTrainSettings {
    public double speed = 0.3;
    public double driveSpeed = 0.6;
    public double turnSpeed = 0.5;

    public double distancePerRevolution = 1.0;
     
     /**
      * Decides what direction the motor encoder is facing. This could also be
      * changed by flipping the a and b ports of the encoder.
      */
     public boolean isEncoderReversed;
     public boolean isEncoderEnabled;
 
     // Autonomous Values //
     public double autonomousSpeed = 0.5;
 
     public Vector2 autonomousStartPosition;
     public Vector2 autonomousEndPosition;
     // etc...
     
     // Ports //
     public int portMotorRight1 = 5;
     public int portMotorRight2 = 4;

     public int portMotorLeft1 = 3;
     public int portMotorLeft2 = 2;
     
     public int portEncoderRightA = 99;
     public int portEncoderRightB = 99;
     
     public int portEncoderLeftA = 99;
     public int portEncoderLeftB = 99;
}