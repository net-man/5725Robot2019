package frc.robot.coordinates;

import utils.Vector2Int;

public class Pathfinding {
    private Vector2Int[] openSet;
    private Vector2Int[] closedSet;

    private Grid grid;

    public Vector2Int[] path;

    public Pathfinding(Grid grid) {
        this.grid = grid;
    }

    public void Solve() {

    }
}