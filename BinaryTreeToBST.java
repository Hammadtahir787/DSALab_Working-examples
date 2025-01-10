import java.util.ArrayList;
import java.util.Collections;

class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
        this.value = value;
        this.left = this.right = null;
    }
}

public class BinaryTreeToBST {
    // Store inorder traversal of the binary tree
    public static void storeInorder(TreeNode node, ArrayList<Integer> inorder) {
        if (node == null) return;
        storeInorder(node.left, inorder);
        inorder.add(node.value);
        storeInorder(node.right, inorder);
    }

    // Build BST using the sorted elements
    public static void buildBST(TreeNode node, ArrayList<Integer> sorted, int[] index) {
        if (node == null) return;
        buildBST(node.left, sorted, index);
        node.value = sorted.get(index[0]++);
        buildBST(node.right, sorted, index);
    }

    public static TreeNode convertToBST(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        
        // Step 1: Store the inorder traversal of the binary tree
        storeInorder(root, inorder);

        // Step 2: Sort the stored values
        Collections.sort(inorder);

        // Step 3: Build the BST using the sorted values
        int[] index = {0}; // Using an array to hold the index
        buildBST(root, inorder, index);

        return root;
    }

    // Inorder traversal to display the tree
    public static void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(30);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(20);
        root.right.right = new TreeNode(5);

        System.out.print("Original Binary Tree (Inorder): ");
        inorder(root);
        System.out.println();

        // Convert to BST
        convertToBST(root);

        System.out.print("Converted BST (Inorder): ");
        inorder(root);
    }
}
