import java.util.PriorityQueue;

public class TotalCostToHireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> pqLeft = new PriorityQueue<>();
        PriorityQueue<Integer> pqRight = new PriorityQueue<>();

        long cost = 0L;
        if (candidates <= costs.length / 2) {
            for (int i = 0; i < candidates; i++) {
                pqLeft.add(costs[i]);
                pqRight.add(costs[costs.length - i - 1]);
            }
        } else {
            for (int i = 0; i < costs.length; i++) {
                pqLeft.add(costs[i]);
            }
            for (int i = 0; i < k; i++) {
                cost += pqLeft.poll();
            }
            return cost;
        }

        int i = candidates;
        int j = costs.length - candidates - 1;
        for (int l = 0; l < k; l++) {
            if (pqLeft.peek() != null && (pqRight.peek() == null || pqLeft.peek() <= pqRight.peek())) {
                cost += pqLeft.poll();
                if (i <= j) {
                    pqLeft.add(costs[i++]);
                }
            } else {
                cost += pqRight.poll();
                if (i <= j) {
                    pqRight.add(costs[j--]);
                }
            }
        }
        return cost;
    }
}

