import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfRecentCalls {
    private final Queue<Integer> pings;
    public NumberOfRecentCalls() {
        pings = new ArrayDeque<>();
    }

    public int ping(int t) {
        pings.add(t);
        while (pings.peek() < t - 3000) {
            pings.poll();
        }
        return pings.size();
    }
}
