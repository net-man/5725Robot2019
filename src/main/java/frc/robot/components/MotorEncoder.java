package frc.robot.components;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

/**
 * MotorEncoder
 */
public class MotorEncoder {
    private Encoder encoder;

    public double value;
    public int count;

    public MotorEncoder(int channelA, int channelB, boolean isReversed) {
        encoder = new Encoder(channelA, channelB, isReversed, EncodingType.k4X);
    }

    public void reset() {
        encoder.reset();
    }

    public int getCountSinceLastCall() {
        int currentCount = count - encoder.get();
        count = encoder.get();

        return currentCount;
    }
}