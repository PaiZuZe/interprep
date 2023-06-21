public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = Integer.MIN_VALUE;
        while (left < right) {
            int newArea = Math.min(height[left], height[right]) * (right - left);
            if (newArea > area) {
                area = newArea;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}
