package frc.robot.extra.settings;

import frc.utils.Vector2;

public class DriveTrainSettings {
    public double driveSpeed;
    public double turnSpeed;

    public double distancePerRevolution;
     
     /**
      * Decides what direction the motor encoder is facing. This could also be
      * changed by flipping the a and b ports of the encoder.
      */
     public boolean isEncoderReversed;
     public boolean isEncoderEnabled;
 
     // Autonomous Values //
     public double autonomousSpeed;
 
     public Vector2 autonomousStartPosition;
     public Vector2 autonomousEndPosition;;
     // etc...
     
     // Ports //
     public int portMotorRight1;
     public int portMotorRight2;

     public int portMotorLeft1;
     public int portMotorLeft2;
     
     public int portEncoderRightA;
     public int portEncoderRightB;
     
     public int portEncoderLeftA;
     public int portEncoderLeftB;
}