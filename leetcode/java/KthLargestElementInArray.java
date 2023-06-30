public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, nums.length - k, 0, nums.length);
    }

    private int quickSelect(int[] nums, int k, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int pivot = nums[end - 1];
        int j = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, j);
                j++;
            }
        }
        if (j - 1 == k) {
            return nums[k];
        } else if (j - 1 < k) {
            return quickSelect(nums, k, j, end);
        }
        return quickSelect(nums, k, start, j - 1);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

