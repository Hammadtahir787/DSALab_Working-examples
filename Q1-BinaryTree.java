class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class BinaryTree {

    // Method to calculate the height of the binary tree
    public int calculateLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = calculateLevel(root.left);
        int rightHeight = calculateLevel(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Level (Height) of the binary tree: " + tree.calculateLevel(root));
    }
}
