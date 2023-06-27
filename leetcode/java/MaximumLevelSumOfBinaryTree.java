import java.util.ArrayList;
import java.util.List;

public class MaximumLevelSumOfBinaryTree {
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int minMaxLevel = 0;
        List<Integer> levelSum = new ArrayList<>();
        dfs(root, 0, levelSum);

        for (int i = 0; i < levelSum.size(); i++) {
            if (levelSum.get(i) > maxSum) {
                minMaxLevel = i;
                maxSum = levelSum.get(i);
            }
        }
        return minMaxLevel + 1;
    }

    private void dfs(TreeNode node, int level, List<Integer> levelSum) {
        if (level == levelSum.size()) {
            levelSum.add(node.val);
        } else {
            levelSum.set(level, levelSum.get(level) + node.val);
        }
        if (node.left != null) {
            dfs(node.left, level + 1, levelSum);
        }
        if (node.right != null) {
            dfs(node.right, level + 1, levelSum);
        }
    }
}
