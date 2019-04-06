package frc.utils;

public class RobotMath {
    public static Vector2 PolarToCartesian(double speed, double angle) {
        double x = Math.sin(angle) * speed;
        double y = Math.cos(angle) * speed;

        return new Vector2(x, y);
    }

    public static Vector2 CartesianToPolar(double x, double y) {
        double a = Math.atan(y / x) * 180 / Math.PI;
        double s = Math.hypot(x, y);

        return new Vector2(a, s);
    }

    public static double Direction(double current, double target) {
        if (current == target)
            return 0;
        return current > target ? -1 : 1;

    }

    public static double Clamp(double current, double min, double max) {
        if (current > max)
            return max;
        if (current < min)
            return min;
        return current;
    }

    public static double Snap(double current, double[] values, double offset) {
        for (int i = 0; i < values.length; i++) {
            if (current <= values[i] + offset) {
                return values[i];
            }
        }

        return current;
    }

    // public static double Map(double current, double currentStart, double currentEnd, double newStart, double newEnd) {
    //     double slope = (currentEnd - currentStart) / (currentEnd - currentStart)
    //     output = output_start + slope * (current - input_start)

    //     return current;
    // }
}