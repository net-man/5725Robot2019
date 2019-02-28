package frc.utils;

public class RobotMath {
    public static Vector2 PolarToCartesian(double speed, double angle) {
        double x = Math.sin(angle)*speed;
        double y = Math.cos(angle)*speed;

        return new Vector2(x, y);
    }

    public static Vector2 CartesianToPolar(double x, double y) {
        double a = Math.atan(y / x) * 180/Math.PI;
        double s = Math.hypot(x, y);
        
        return new Vector2(a, s);
    }

    public static double Direction(double current, double target) {
        if(current == target) return 0;
        return current > target ? 1 : -1;
        
    }
}