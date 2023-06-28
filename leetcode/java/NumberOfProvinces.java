public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int components = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(i, isConnected, visited);
                components++;
            }
        }
        return components;
    }

    private void dfs(int vertex, int[][] isConnected, boolean[] visited) {
        visited[vertex] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[vertex][i] == 1 && !visited[i]) {
                dfs(i, isConnected, visited);
            }
        }
    }
}
