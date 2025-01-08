class Node{
    int key;
    Node left, right;
    public Node(int item){
        key=item;
        left=right=null;
    }
}
public class Main{
    Node root;
    Main(int key){
        root=new Node(key);
    }
    Main(){
        root=null;
    }
    void printPostOrder(Node node){
        if(node == null)
        return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.println(node.key+ " ");
    }
     void printInOrder(Node node){
        if(node == null)
        return;
        printInOrder(node.left);
        System.out.println(node.key+ " ");
        printInOrder(node.right);
    }
    void printPreOrder(Node node){
        if(node == null)
        return;
        System.out.println(node.key+ " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
    public Node search(Node root,int key){
        if(root==null || root.key==key)
        return root;
        if(root.key>key)
        return search(root.left, key);
        return search (root.right,key);
    }
    //insretion
    Node insertRec(Node root, int key){
    if(root == null){
        root = new Node(key);
        return root;
    }
    else{
        if(key<root.key)
        root.left = insertRec(root.left,key);
        else if(key>root.key)
        root.right = insertRec(root.right,key);
    }
    return root;
    }
    Node deleteRec(Node root,int key){
        if(root == null)  return root;
        if (key<root.key)
        root.left = deleteRec(root.left,key);
        else if(key>root.key)
        root.right = deleteRec(root.right,key);
        else{
            if(root.left == null)
            return root.right;
            else if(root.right == null)
            return root.left;
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
         }
         return root;
    }
    int minValue(Node root){
        int minv = root.key;
        while(root.left != null)
        {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
    public static void main(String[] args){
        Main tree = new Main();
        tree.root = new Node(8);//creating root
        Node a = new Node(3);
        tree.root.left = a;
        Node b = new Node(10);
        tree.root.right = b;
        
        a.left = new Node(1);
        a.right = new Node(6);
        
        b.left = new Node(9);
        b.right = new Node(13);
        
        System.out.println("Pre-Order");
        tree.printPreOrder(tree.root);
        System.out.println("\nPost-Order");
        tree.printPostOrder(tree.root);
        System.out.println("\nIn-Order");
        tree.printInOrder(tree.root);
    }
   
}
