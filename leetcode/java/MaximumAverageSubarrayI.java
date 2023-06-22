public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int kSum = 0;
        int maxKSum;
        for (int i = 0; i < k; i++) {
            kSum += nums[i];
        }
        maxKSum = kSum;

        for (int i = k; i < nums.length; i++) {
            kSum = kSum - nums[i - k] + nums[i];
            maxKSum = Math.max(maxKSum, kSum);
        }
        return maxKSum / (k * 1.0);
    }
}
