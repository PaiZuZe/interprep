import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {
    private record Edge(String from, String to, double weight) {}

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] queriesAnswer = new double[queries.size()];
        Map<String, List<Edge>> connections = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String v = equations.get(i).get(0);
            String w = equations.get(i).get(1);
            connections.putIfAbsent(v, new ArrayList<>());
            connections.get(v).add(new Edge(v, w, values[i]));
            connections.putIfAbsent(w, new ArrayList<>());
            connections.get(w).add(new Edge(w, v, 1 / values[i]));
        }

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String v = query.get(0);
            String w = query.get(1);
            if (connections.get(v) == null || connections.get(w) == null) {
                queriesAnswer[i] = -1.0;
                continue;
            }
            Map<String, Boolean> visited = new HashMap<>();
            Map<String, Edge> path = new HashMap<>();
            dfs(v, connections, visited, path);
            double answer = retracePath(v, w, path);
            if (answer == Double.NEGATIVE_INFINITY) {
                queriesAnswer[i] = -1.0;
            } else {
                queriesAnswer[i] = answer;
            }
        }
        return queriesAnswer;
    }
    private void dfs(String vertex, Map<String, List<Edge>> connections, Map<String, Boolean> visited, Map<String, Edge> path) {
        if (visited.putIfAbsent(vertex, true) == null) {
            for (Edge edge: connections.get(vertex)) {
                String w = edge.to;
                if (visited.get(w) == null) {
                    path.put(w, edge);
                    dfs(w, connections, visited, path);
                }
            }
        }
    }

    private double retracePath(String start, String end, Map<String, Edge> path) {
        if (start.equals(end)) {
            return 1.0;
        }
        if (path.get(end) == null) {
            return Double.NEGATIVE_INFINITY;
        }
        return path.get(end).weight() * retracePath(start, path.get(end).from, path);
    }
}
