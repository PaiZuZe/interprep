import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int room = queue.poll();
            if (!visited[room]) {
                visited[room] = true;
                for (int key: rooms.get(room)) {
                    if (!visited[key]) {
                        queue.add(key);
                    }
                }
            }

        }

        for (boolean roomVisited : visited) {
            if (!roomVisited) {
                return false;
            }
        }
        return true;
    }
}
