import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> frontier = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[] start = new int[] {entrance[0], entrance[1], 0};

        frontier.add(start);
        visited[start[0]][start[1]] = true;
        while (!frontier.isEmpty()) {
            int[] coordinates = frontier.poll();
            if (isExit(coordinates, maze) && isDifferentCord(coordinates, start)) {
                return coordinates[2];
            }
            List<int[]> neighbors = getNeighbors(coordinates, maze, visited);
            for (int[] neighbor: neighbors) {
                visited[neighbor[0]][neighbor[1]] = true;
                frontier.add(neighbor);
            }
        }
        return -1;
    }

    private List<int[]> getNeighbors(int[] position, char[][] maze, boolean[][] visited) {
        List<int[]> neighbors = new LinkedList<>();
        int i = position[0];
        int j = position[1];

        if (i > 0 && maze[i - 1][j] == '.' && !visited[i - 1][j]) {
            int[] leftNeighbor = new int[] {i - 1, j, position[2] + 1};
            neighbors.add(leftNeighbor);
        }
        if (i < maze.length - 1 && maze[i + 1][j] == '.' && !visited[i + 1][j]) {
            int[] rightNeighbor = new int[]{i + 1, j, position[2] + 1};
            neighbors.add(rightNeighbor);
        }
        if (position[1] > 0 && maze[i][j - 1] == '.' && !visited[i][j - 1]) {
            int[] upNeighbor = new int[]{i, j - 1, position[2] + 1};
            neighbors.add(upNeighbor);
        }
        if (position[1] < maze[0].length - 1 && maze[i][j + 1] == '.' && !visited[i][j + 1]) {
            int[] downNeighbor = new int[]{i, j + 1, position[2] + 1};
            neighbors.add(downNeighbor);
        }
        return neighbors;
    }

    private boolean isExit(int[] position, char[][] maze) {
        int n = maze.length - 1;
        int m = maze[0].length - 1;
        int i = position[0];
        int j = position[1];
        return i == 0 || i == n || j == 0 || j == m;
    }

    private boolean isDifferentCord(int[] positionA, int[] positionB) {
        return (positionA[0] != positionB[0] || positionA[1] != positionB[1]);
    }
}

