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

    public void removeDuplicates() {
        if (head == null) return;

        Node current = head;
        
        while (current != null && current.next != null) {
           
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
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
        list.append(20);
        list.append(30);
        list.append(30);
        list.append(40);

        System.out.println("Original List:");
        list.printList();

        list.removeDuplicates();
        System.out.println("List after removing duplicates:");
        list.printList();
    }
}
