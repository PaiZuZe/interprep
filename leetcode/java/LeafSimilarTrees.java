import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<TreeNode> leaves1 = getLeaves(root1);
        List<TreeNode> leaves2 = getLeaves(root2);
        if (leaves1.size() != leaves2.size()) {
            return false;
        }
        for (int i = 0; i < leaves1.size(); i++) {
            if (leaves1.get(i).val != leaves2.get(i).val) {
                return false;
            }
        }

        return true;
    }

    private List<TreeNode> getLeaves(TreeNode root) {
        List<TreeNode> leaves = new ArrayList<>();
        getLeaves(root, leaves);
        return leaves;
    }
    private void getLeaves(TreeNode root, List<TreeNode> leaves) {
        if (root == null) {
            return;
        }
        if (root.right == null && root.left == null) {
            leaves.add(root);
        }
        getLeaves(root.left, leaves);
        getLeaves(root.right, leaves);
    }
}
