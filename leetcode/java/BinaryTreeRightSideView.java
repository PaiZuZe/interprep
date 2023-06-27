import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        if (root == null) {
            return nodes;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        nodes.add(root.val);
        queue.add(root);

        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue2.add(node.left);
                }
                if (node.right != null) {
                    queue2.add(node.right);
                }
            }
            if (!queue2.isEmpty()) {
                nodes.add(queue2.getLast().val);
            }
            queue = queue2;
            queue2 = new LinkedList<>();
        }
        return nodes;
    }
}

// Hello my name is Victor, I'm a Backend developer. My latest job was working on the migration of a login system.
// From a monolithic to microservices as well as changing the authentication backend from Microst AD
// to AWS Cognito. And I would the biggest challenge was the async communication between all the services.
