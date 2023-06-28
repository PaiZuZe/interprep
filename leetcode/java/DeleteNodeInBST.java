import java.util.HashMap;
import java.util.Map;

public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);
        TreeNode toBeDeleted = searchBST(root, key, parents);
        TreeNode toSwap;
        if (toBeDeleted == null) {
            return root;
        }
        if (toBeDeleted.left == null && toBeDeleted.right == null) {
            toSwap = null;
        } else if (toBeDeleted.right == null) {
            toSwap = getRightMost(toBeDeleted.left, parents);
            if (parents.get(toSwap) != null) {
                parents.get(toSwap).right = toSwap.left;
            }
        } else {
            toSwap = getLeftMost(toBeDeleted.right, parents);
            if (parents.get(toSwap) != null) {
                parents.get(toSwap).left = toSwap.right;
            }
        }

        if (toBeDeleted != root) {
            if (parents.get(toBeDeleted).left == toBeDeleted) {
                parents.get(toBeDeleted).left = toSwap;
            } else {
                parents.get(toBeDeleted).right = toSwap;
            }
        } else {
            root = toSwap;
        }


        if (toSwap != null) {
            if (toBeDeleted.left != toSwap) {
                toSwap.left = toBeDeleted.left;
            }
            if (toBeDeleted.right != toSwap) {
                toSwap.right = toBeDeleted.right;
            }
        }
        return root;
    }
    private TreeNode searchBST(TreeNode root, int val, Map<TreeNode, TreeNode> parents) {
        if (root == null) {
            return null;
        } else if (root.val == val) {
            return root;
        } else if (val < root.val) {
            parents.put(root.left, root);
            return searchBST(root.left, val, parents);
        } else {
            parents.put(root.right, root);
            return searchBST(root.right, val, parents);
        }
    }

    private TreeNode getLeftMost(TreeNode root, Map<TreeNode, TreeNode> parents) {
        if (root == null || root.left == null) {
            return root;
        }
        parents.put(root.left, root);
        return getLeftMost(root.left, parents);
    }

    private TreeNode getRightMost(TreeNode root, Map<TreeNode, TreeNode> parents) {
        if (root == null || root.right == null) {
            return root;
        }
        parents.put(root.right, root);
        return getLeftMost(root.right, parents);
    }
}
