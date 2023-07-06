import java.util.Arrays;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i < dp.length; i++) {
            int tempSecondSpot = dp[i - 2] + cost[i - 2];
            int tempFirstSpot = dp[i - 1] + cost[i - 1];
            dp[i] = Math.min(tempFirstSpot, tempSecondSpot);
        }
        return dp[dp.length - 1];
    }
}

