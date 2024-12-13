
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeProperties {

    // Method to check if the tree is a full binary tree
    public boolean isFullTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if ((root.left == null && root.right != null) || (root.left != null && root.right == null)) {
            return false;
        }
        return isFullTree(root.left) && isFullTree(root.right);
    }

    // Method to check if the tree is a complete binary tree
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean seenNull = false;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current == null) {
                seenNull = true;
            } else {
                if (seenNull) {
                    return false; // If we see a non-null node after a null, it's not complete
                }
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BinaryTreeProperties tree = new BinaryTreeProperties();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println("Is Full Binary Tree: " + tree.isFullTree(root));
        System.out.println("Is Complete Binary Tree: " + tree.isCompleteTree(root));
    }
}
