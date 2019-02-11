package frc.utils;

public class RobotMath {
    public static Vector2 PolarToCartesian(double speed, double angle) {
        double x = Math.sin(angle)*speed;
        double y = Math.cos(angle)*speed;

        return new Vector2(x, y);
    }

    public static Vector2 CartesianToPolar(double x, double y) {
        return new Vector2();
        // FIXME: Implement Cartesian to Polar.
    }
}