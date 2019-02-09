package frc.robot.coordinates;

import java.util.List;

import frc.utils.Vector2Int;

public class Pathfinding {

    private List<Vector2Int> openSet;
    private List<Vector2Int> closedSet;

     private Grid grid;

    public Vector2Int[] path;

    public Pathfinding(Grid grid) {
         this.grid = grid;
    }

    public void Solve(Vector2Int start, Vector2Int goal) {
        openSet.add(start);

        Vector2Int current = new Vector2Int();
        Vector2Int[] neighbours = new Vector2Int[4];

        while(current.x != goal.x && current.y != goal.y) {
            for(int i = 0; i <= openSet.size()-1; i++) {
                // Get the highest 'f' valued node in the open set.
                if(grid.nodes[openSet.get(i).x][openSet.get(i).y].f > grid.nodes[current.x][current.y].f) {
                    current = openSet.get(i);
                }
            }

            // Remove current from the open set and add it to the closed set.
            openSet.remove(current);
            closedSet.add(current);

            // Get the new g of neighbours which is current g + 1 because we are taking another step.
            int g = grid.nodes[current.x][current.y].g + 1;            

            // Get the new current's neighbours.
            neighbours = grid.GetNeighbours(current.x, current.y);

            for(int j = 0; j <= neighbours.length-1; j++) {
                // If neighbour is part of the closed set, continue.
                if(closedSet.contains(neighbours[j])) continue;

                // If our neighbour is not part of the open set, add them to it.
                if(!openSet.contains(neighbours[j])) openSet.add(neighbours[j]);
                
                // If the neigbours already have a g value but the path we are on is better then choose our path's g.
                if(g < grid.nodes[neighbours[j].x][neighbours[j].y].g) {
                    grid.nodes[neighbours[j].x][neighbours[j].y].g = g;

                    // Since our path seems better then the one we are overriding, we need to recalculate it's f value.
                    // Calculating h is the distance between the goal and the neigbour. To do this we need (vector2Int a - vector2Int b).magnitude.
                    // Magnitude is calculated as the square root of x*x + y*y.
                    int tempx = neighbours[j].x - goal.x;
                    int tempy = neighbours[j].y - goal.y;
                    double h = Math.sqrt(tempx * tempx + tempy * tempy);
                    grid.nodes[neighbours[j].x][neighbours[j].y].f = h + g;
                }
                
            }
        }
    }
}