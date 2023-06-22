public class LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        return longestOnes(nums, 1) - 1;
    }

    private int longestOnes(int[] nums, int k) {
        int zeros = 0;
        int length = 0;

        while (length < nums.length) {
            if (nums[length] == 0) {
                if (zeros == k) {
                    break;
                }
                zeros++;
            }
            length++;
        }

        for (int i = length; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (zeros <= k) {
                    length++;
                } else if (nums[i - length] == 0) {
                    zeros--;
                }
            } else {
                zeros++;
                if (zeros < k) {
                    length++;
                } else {
                    if (nums[i - length] == 0) {
                        zeros--;
                    }
                }
            }
        }
        return length;
    }
}
