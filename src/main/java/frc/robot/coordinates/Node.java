package frc.robot.coordinates;

public class Node {
    public double f;
    public int g;

    public Node(double f) {
        this.f = f;
        g = 0;
    }

    public Node() {
        this.f = 0.0;
        g = 0;
    }
}