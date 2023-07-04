public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        return findPeakElement(nums, 0, nums.length);
    }

    private int findPeakElement(int[] nums, int start, int end) {
        int middle = start + ((end - start) / 2);
        if (middle == 0) {
            if (nums[middle] > nums[middle + 1]) {
                return middle;
            } else {
                return findPeakElement(nums, middle, end);
            }
        }
        if (middle == nums.length - 1) {
            if (nums[middle] > nums[middle - 1]) {
                return middle;
            } else {
                return findPeakElement(nums, start, middle);
            }
        }
        if (nums[middle - 1] < nums[middle] && nums[middle] > nums[middle + 1]) {
            return middle;
        } else if (nums[middle] < nums[middle + 1]) {
            return findPeakElement(nums, middle, end);
        } else {
            return findPeakElement(nums, start, middle);
        }
    }
}

