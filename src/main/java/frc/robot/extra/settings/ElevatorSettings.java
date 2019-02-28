package frc.robot.extra.settings;

public class ElevatorSettings {
     // Values //
     public double speed;
    
     public double distancePerRevolution;
     
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
     public int portMotor;
     public int portEncoderA;
     public int portEncoderB;
}