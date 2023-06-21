import java.util.Arrays;

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int count = 0;

        while (left < right) {
            int combined = nums[left] + nums[right];
            if (combined == k) {
                left++;
                right--;
                count++;
            } else if (combined > k) {
                right--;
            } else {
                left++;
            }
        }
        return count;
    }
}
