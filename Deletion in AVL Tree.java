class AVLNode {
    int value, height;
    AVLNode left, right;

    AVLNode(int value) {
        this.value = value;
        this.height = 1; // Initial height of a node is 1
    }
}

public class AVLTree {
    AVLNode root;

    // Get the height of the node
    private int height(AVLNode node) {
        return (node == null) ? 0 : node.height;
    }

    // Calculate balance factor
    private int getBalance(AVLNode node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    // Perform a right rotation
    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x; // New root
    }

    // Perform a left rotation
    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y; // New root
    }

    // Insert a node into the AVL tree
    private AVLNode insert(AVLNode node, int value) {
        if (node == null) return new AVLNode(value);

        if (value < node.value)
            node.left = insert(node.left, value);
        else if (value > node.value)
            node.right = insert(node.right, value);
        else
            return node; // Duplicates are not allowed

        // Update height
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // Check balance factor and rebalance if needed
        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && value < node.left.value)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && value > node.right.value)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && value > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && value < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;
        while (current.left != null) current = current.left;
        return current;
    }

    private AVLNode delete(AVLNode root, int value) {
        if (root == null) return root;

        if (value < root.value)
            root.left = delete(root.left, value);
        else if (value > root.value)
            root.right = delete(root.right, value);
        else {
            if ((root.left == null) || (root.right == null)) {
                AVLNode temp = (root.left != null) ? root.left : root.right;
                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp; 
            } else {
                AVLNode temp = minValueNode(root.right);
                root.value = temp.value; 
                root.right = delete(root.right, temp.value); 
            }
        }

        if (root == null) return root;

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    public void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Insert nodes
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        System.out.print("Inorder traversal before deletion: ");
        tree.inorder(tree.root);
        System.out.println();

        // Delete a node
        tree.delete(40);

        System.out.print("Inorder traversal after deletion: ");
        tree.inorder(tree.root);
    }
}
