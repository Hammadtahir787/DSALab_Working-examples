class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    public SinglyLinkedList reverseCopy() {
        SinglyLinkedList reversedList = new SinglyLinkedList();
        Node current = head;

        while (current != null) {
            Node newNode = new Node(current.data); 
            newNode.next = reversedList.head;      
            reversedList.head = newNode;           
            current = current.next;
        }

        return reversedList; 
    }

   
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);

        System.out.println("Original List:");
        list.printList();

     
        SinglyLinkedList reversedList = list.reverseCopy();
        System.out.println("Reversed List:");
        reversedList.printList();

        System.out.println("Original List after reversing:");
        list.printList();  
    }
}
