package utils;

public class Vector2 {
    public double x;
    public double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2() {
        this.x = 0;
        this.y = 0;
    }

    public void Add(Vector2 vector) {
        x += vector.x;
        y += vector.y;
    }
    public void Subtract(Vector2 vector) {
        x -= vector.x;
        y -= vector.y;
    }
    public void Multiply(Vector2 vector) {
        x *= vector.x;
        y *= vector.y;
    }
    public void Divide(Vector2 vector) {
        x /= vector.x;
        y /= vector.y;
    }

}