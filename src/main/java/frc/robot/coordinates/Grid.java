package frc.robot.coordinates;

import frc.utils.Vector2;
import frc.utils.Vector2Int;

public class Grid {
    public Node[][] nodes;

    public Grid(int sizeX, int sizeY) {
        nodes = new Node[sizeX][sizeY];
    }

    public Vector2Int[] GetNeighbours(int x, int y) {
        if(x > nodes.length-1 || x < nodes.length-1 || y > nodes[x].length-1 || y < nodes[x].length-1) {
            System.out.println("ERR: Can't get neighbours as requested node is out of range.");
            return null;
        }

        Vector2Int[] neighbours = new Vector2Int[4];
        if(x + 1 < nodes.length-1) neighbours[0] = new Vector2Int(x + 1, y);
        if(x - 1 < nodes.length-1) neighbours[1] = new Vector2Int(x + 1, y);
        if(y + 1 < nodes[x].length-1) neighbours[2] = new Vector2Int(x, y + 1);
        if(y - 1 < nodes[x].length-1) neighbours[3] = new Vector2Int(x, y - 1);

        return neighbours;
    }

    public Vector2 WorldToGridCoords(double x, double y) {
        // TODO: Implement.
        return new Vector2();
    }

    public Vector2 GridToWorldCoords(int x, int y) {
        // TODO: Implement.
        return new Vector2();
    }
}