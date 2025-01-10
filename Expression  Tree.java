 
class TreeNode {
    String value;
    TreeNode left, right;

    TreeNode(String value) {
        this.value = value;
        this.left = this.right = null;
    }
}

public class ExpressionTree {
    public static TreeNode createExpressionTree() {
        TreeNode root = new TreeNode("/");
        root.left = new TreeNode("*");
        root.right = new TreeNode("+");

        root.left.left = new TreeNode("+");
        root.left.right = new TreeNode("-");
        root.right.left = new TreeNode("2");
        root.right.right = new TreeNode("9");

        root.left.left.left = new TreeNode("5");
        root.left.left.right = new TreeNode("2");
        root.left.right.left = new TreeNode("2");
        root.left.right.right = new TreeNode("1");

        return root;
    }

    public static void inorder(TreeNode node) {
        if (node == null) return;
        if (node.left != null || node.right != null) System.out.print("(");
        inorder(node.left);
        System.out.print(" " + node.value + " ");
        inorder(node.right);
        if (node.left != null || node.right != null) System.out.print(")");
    }

    public static void postorder(TreeNode node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }

    public static void main(String[] args) {
        TreeNode root = createExpressionTree();
        System.out.print("Inorder traversal: ");
        inorder(root);
        System.out.println();
        System.out.print("Postorder traversal: ");
        postorder(root);
    }
}
