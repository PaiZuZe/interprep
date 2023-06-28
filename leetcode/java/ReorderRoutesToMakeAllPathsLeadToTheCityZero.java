import java.util.ArrayList;
import java.util.List;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    private int reorders = 0;

    public int minReorder(int n, int[][] connections) {
        boolean[] visited = new boolean[n];
        List<List<int[]>> betterConnections = betterConnections(n, connections);

        dfs(0, betterConnections, visited);
        return reorders;
    }

    private void dfs(int vertex, List<List<int[]>> connections, boolean[] visited) {
        visited[vertex] = true;
        List<int[]> edges = connections.get(vertex);
        for (int[] edge : edges) {
            if (edge[0] == vertex && !visited[edge[1]]) {
                reorders++;
                dfs(edge[1], connections, visited);
            }
            if (edge[1] == vertex && !visited[edge[0]]) {
                dfs(edge[0], connections, visited);
            }
        }
    }

    private List<List<int[]>> betterConnections(int n, int[][] connections) {
        List<List<int[]>> betterConnections = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            betterConnections.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            betterConnections.get(connection[0]).add(connection);
            betterConnections.get(connection[1]).add(connection);
        }
        return betterConnections;
    }
}
