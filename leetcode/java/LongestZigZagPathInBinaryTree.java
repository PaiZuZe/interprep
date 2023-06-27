public class LongestZigZagPathInBinaryTree {
    private enum ZigZag {
        ZIG, ZAG;
    }
    private int tempMax = 0;

    public int longestZigZag(TreeNode root) {
        longestZigZag(root, ZigZag.ZIG, 0);
        longestZigZag(root, ZigZag.ZAG, 0);
        return tempMax;
    }

    private void longestZigZag(TreeNode root, ZigZag zigZag, int length) {
        if (root == null) {
            return;
        }
        tempMax = Math.max(tempMax, length);
        if (zigZag == ZigZag.ZIG) {
            longestZigZag(root.right, ZigZag.ZAG, length + 1);
            longestZigZag(root.left, ZigZag.ZIG, 1);
        } else {
            longestZigZag(root.left, ZigZag.ZIG, length + 1);
            longestZigZag(root.right, ZigZag.ZAG, 1);
        }

    }
}
