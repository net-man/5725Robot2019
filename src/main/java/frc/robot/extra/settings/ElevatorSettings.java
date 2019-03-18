package frc.robot.extra.settings;

public class ElevatorSettings {
     // Values //
     public double speed = 0.4;
    
     public double distancePerRevolution = 1.0;
     
     /**
      * Decides what direction the motor encoder is facing. This could also be
      * changed by flipping the a and b ports of the encoder.
      */
     public boolean isEncoderReversed;
     public boolean isEncoderEnabled;
 
     // Autonomous Values //
     public double autonomousSpeedUp;
     public double autonomousSpeedDown;
 
     public double autonomousTopPosition;
     public double autonomousBottomPosition;

     public double autonomousHatchPickupPosition;
     // etc...
     
     // Ports //
     public int portMotor = 9;
     public int portEncoderA = 99;
     public int portEncoderB = 99;
}