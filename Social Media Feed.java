
class Node {
    int data; 
    Node next; 


    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
    class LinkedList {
    private Node head; 

  
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) { 
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) { 
                temp = temp.next;
            }
            temp.next = newNode; 
        }
    }

    public void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next; 
        }
        System.out.println("null");
    }
}
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

    
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

      
        System.out.println("Traversing the LinkedList:");
        list.traverse();
    }
}




// Insertion into a Singly LinkedList

// At the beginning
// At a specified position
class Node {
    int data; // Data stored in the node
    Node next; // Reference to the next node

    // Constructor
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class LinkedList {
    private Node head; // Head of the list

    // Add a new node at the beginning of the list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head; // Point the new node to the current head
        head = newNode; // Update head to the new node
    }

    // Insert a new node at a specified position
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);

        if (position == 0) { // If inserting at the head
            insertAtBeginning(data);
            return;
        }

        Node temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next; // Traverse to the node before the target position
        }

        if (temp == null) {
            throw new IllegalArgumentException("Position out of bounds");
        }

        newNode.next = temp.next; // Link the new node to the next node
        temp.next = newNode; // Link the previous node to the new node
    }

    // Traverse the list and print each node's data
    public void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next; // Move to the next node
        }
        System.out.println("null"); // End of the list
    }
}
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Insert elements at the beginning
        list.insertAtBeginning(30);
        list.insertAtBeginning(20);
        list.insertAtBeginning(10);

        System.out.println("After inserting at the beginning:");
        list.traverse();

        // Insert elements at specified positions
        list.insertAtPosition(25, 2); // Insert 25 at position 2 (0-based index)
        list.insertAtPosition(5, 0);  // Insert 5 at position 0 (beginning)
        list.insertAtPosition(40, 5); // Insert 40 at the end (position 5)

        System.out.println("After inserting at specified positions:");
        list.traverse();
    }
}







