public class ChildrenSumProperty {

    public boolean hasChildrenSumProperty(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true; // Leaf node or empty tree
        }

        int leftData = (root.left != null) ? root.left.data : 0;
        int rightData = (root.right != null) ? root.right.data : 0;

        if (root.data == leftData + rightData && hasChildrenSumProperty(root.left) && hasChildrenSumProperty(root.right)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        ChildrenSumProperty tree = new ChildrenSumProperty();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(2);

        System.out.println("Has Children Sum Property: " + tree.hasChildrenSumProperty(root));
    }
}
