package frc.robot.extra.settings;

public class ArmSettings {
    // Values //
    public double speed = 0.6;
    
    public double distancePerRevolution = 1.0;
    
    /**
     * Decides what direction the motor encoder is facing. This could also be
     * changed by flipping the a and b ports of the encoder.
     */
    public boolean isEncoderReversed;
    public boolean isEncoderEnabled;

    // Autonomous Values //
    public double autonomousSpeedOpen;
    public double autonomousSpeedClose;

    public double autonomousBallClosedPosition;
    
    // Ports //
    public int portMotor = 7;
    public int portEncoderA = 99;
    public int portEncoderB = 99;
}