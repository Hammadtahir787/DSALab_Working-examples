class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
        this.value = value;
        this.left = this.right = null;
    }
}

public class SortedArrayToBinarySearchTree {
    // Function to convert a sorted array into a BST
    public static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2; // Find the middle element
        TreeNode node = new TreeNode(nums[mid]); // Create the root node

        // Recursively build the left and right subtrees
        node.left = sortedArrayToBST(nums, start, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, end);

        return node;
    }

    // Inorder traversal to verify the BST structure
    public static void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = sortedArrayToBST(sortedArray, 0, sortedArray.length - 1);

        System.out.print("Inorder traversal of the BST: ");
        inorder(root);
    }
}
