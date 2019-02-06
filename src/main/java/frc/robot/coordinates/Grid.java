package frc.robot.coordinates;

import frc.utils.Vector2Int;

public class Grid {
    public Node[][] nodes;

    public enum Positions {
        // Robot Start //
        ROBOT_START_1(0, 0, 0.0),
        ROBOT_START_2(0, 0, 0.0),
        ROBOT_START_3(0, 0, 0.0),

        // Field Hatch Pickup //
        FIELD_HATCH_PICKUP_RIGHT_1(0, 0, 0.0),
        FIELD_HATCH_PICKUP_LEFT_1(0, 0, 0.0),

        // Field Ball Pickup //
        FIELD_BALL_PICKUP_RIGHT_1(0, 0, 0.0),
        FIELD_BALL_PICKUP_LEFT_1(0, 0, 0.0),

        DEFAULT(0, 0, 0.0);

        public Vector2Int position;
        public double rotation;
        private Positions(int x, int y, double rotation) {
            position.x = x;
            position.y = y;
            this.rotation = rotation;
        }
    }

    public enum NeighbourIndex {
        RIGHT(0),
        LEFT(1),
        TOP(2),
        BOTTOM(3);

        int index;
        NeighbourIndex(int index) {
            this.index = index;
        }
    }

    public Grid(int sizeX, int sizeY) {
        nodes = new Node[sizeX][sizeY];
    }

    public Vector2Int[] GetNeighbours(int x, int y) {
        if(x > nodes.length-1 || x < nodes.length-1 || y > nodes[x].length-1 || y < nodes[x].length-1) {
            System.out.println("ERR: Can't get neighbours as requested node is out of range.");
            return null;
        }

        Vector2Int[] neighbours = new Vector2Int[4];
        if(x + 1 < nodes.length-1) neighbours[NeighbourIndex.RIGHT.index] = new Vector2Int(x + 1, y);
        if(x - 1 < nodes.length-1) neighbours[NeighbourIndex.RIGHT.index] = new Vector2Int(x + 1, y);
        if(y + 1 < nodes[x].length-1) neighbours[NeighbourIndex.RIGHT.index] = new Vector2Int(x, y + 1);
        if(y - 1 < nodes[x].length-1) neighbours[NeighbourIndex.RIGHT.index] = new Vector2Int(x, y - 1);

        return neighbours;
    }
}