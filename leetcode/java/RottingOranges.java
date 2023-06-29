import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> frontier = new LinkedList<>();
        int turns = 0;
        int[][] neighborIncrements = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int freshCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    frontier.add(new int[] {i, j, 0});
                }
            }
        }

        while (!frontier.isEmpty()) {
            int[] cell = frontier.poll();
            for (int[] increment: neighborIncrements) {
                int i = cell[0] + increment[0];
                int j = cell[1] + increment[1];
                if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
                    grid[i][j] = 2;
                    freshCount--;
                    turns = Math.max(turns, cell[2] + 1);
                    frontier.add(new int[] {i, j, cell[2] + 1});
                }
            }
        }

        if (freshCount == 0) {
            return turns;
        }
        return -1;
    }
}
