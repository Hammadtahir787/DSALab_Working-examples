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

    public static SinglyLinkedList mergeSortedLists(SinglyLinkedList list1, SinglyLinkedList list2) {
        SinglyLinkedList mergedList = new SinglyLinkedList();
        Node dummy = new Node(0);
        Node current = dummy;

        Node current1 = list1.head;
        Node current2 = list2.head;

        while (current1 != null && current2 != null) {
            if (current1.data <= current2.data) {
                current.next = new Node(current1.data);
                current1 = current1.next;
            } else {
                current.next = new Node(current2.data);
                current2 = current2.next;
            }
            current = current.next;
        }

        while (current1 != null) {
            current.next = new Node(current1.data);
            current1 = current1.next;
            current = current.next;
        }

        while (current2 != null) {
            current.next = new Node(current2.data);
            current2 = current2.next;
            current = current.next;
        }

        mergedList.head = dummy.next; 
        return mergedList;
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
        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.append(1);
        list1.append(3);
        list1.append(5);

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.append(2);
        list2.append(4);
        list2.append(6);

        System.out.println("List 1:");
        list1.printList();
        System.out.println("List 2:");
        list2.printList();

        SinglyLinkedList mergedList = SinglyLinkedList.mergeSortedLists(list1, list2);
        System.out.println("Merged Sorted List:");
        mergedList.printList();
    }
}
