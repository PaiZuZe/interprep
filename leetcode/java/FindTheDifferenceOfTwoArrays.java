import java.util.ArrayList;
import java.util.List;

public class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int[] nums1Freq = new int[2001];
        int[] nums2Freq = new int[2001];

        for (int num1 : nums1) {
            nums1Freq[num1 + 1000]++;
        }
        for (int num2 : nums2) {
            nums2Freq[num2 + 1000]++;
        }

        List<Integer> num1Uniques = new ArrayList<>();
        for (int num1: nums1) {
            if (nums2Freq[num1 + 1000] == 0) {
                num1Uniques.add(num1);
                nums2Freq[num1 + 1000] = -1;
            }
        }

        List<Integer> num2Uniques = new ArrayList<>();
        for (int num2: nums2) {
            if (nums1Freq[num2 + 1000] == 0) {
                num2Uniques.add(num2);
                nums1Freq[num2 + 1000] = -1;
            }
        }
        return List.of(num1Uniques, num2Uniques);
    }
}
