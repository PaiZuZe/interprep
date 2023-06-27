public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    private int goodNodes(TreeNode root, int maximumInPath) {
        if (root == null) {
            return 0;
        }
        if (root.val >= maximumInPath) {
            return 1 + goodNodes(root.left, root.val) + goodNodes(root.right, root.val);
        } else {
            return goodNodes(root.left, maximumInPath) + goodNodes(root.right, maximumInPath);
        }
    }
}
