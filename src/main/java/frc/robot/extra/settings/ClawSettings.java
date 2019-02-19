package frc.robot.extra.settings;

public class ClawSettings {
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
    public double autonomousSpeedOpen;
    public double autonomousSpeedClose;

    public double autonomousBallClosedPosition;
    
    // Ports //
    public int portMotor;
    public int portEncoderA;
    public int portEncoderB;
}