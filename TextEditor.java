/*Create a text editor using doubly linked list, which includes the text area in which user
can enter data, delete and modify it. Proper menu at the top of the editor is not needed.*/
import java.util.Scanner;

class CharNode {
    char data;
    CharNode prev;
    CharNode next;

    public CharNode(char data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class TextEditor {
    CharNode head;
    CharNode tail;

    public void addChar(char data) {
        CharNode newNode = new CharNode(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void deleteCharAtPosition(int position) {
        if (head == null) {
            System.out.println("The text area is empty.");
            return;
        }

        if (position < 0) {
            System.out.println("Invalid position.");
            return;
        }

        CharNode current = head;
        int currentIndex = 0;

        while (current != null && currentIndex < position) {
            current = current.next;
            currentIndex++;
        }

        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        if (current == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (current == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        System.out.println("Character at position " + position + " deleted.");
    }

    public void modifyCharAtPosition(int position, char newChar) {
        if (head == null) {
            System.out.println("The text area is empty.");
            return;
        }

        CharNode current = head;
        int currentIndex = 0;

        while (current != null && currentIndex < position) {
            current = current.next;
            currentIndex++;
        }

        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        current.data = newChar;
        System.out.println("Character at position " + position + " modified.");
    }

    public void displayText() {
        if (head == null) {
            System.out.println("The text area is empty.");
            return;
        }

        CharNode current = head;
        System.out.println("Current text:");
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nText Editor Menu:");
            System.out.println("1. Add character");
            System.out.println("2. Delete character at position");
            System.out.println("3. Modify character at position");
            System.out.println("4. Display text");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter character to add: ");
                    char c = scanner.next().charAt(0);
                    editor.addChar(c);
                    break;
                case 2:
                    System.out.print("Enter position to delete (starting from 0): ");
                    int posDelete = scanner.nextInt();
                    editor.deleteCharAtPosition(posDelete);
                    break;
                case 3:
                    System.out.print("Enter position to modify (starting from 0): ");
                    int posModify = scanner.nextInt();
                    System.out.print("Enter new character: ");
                    char newChar = scanner.next().charAt(0);
                    editor.modifyCharAtPosition(posModify, newChar);
                   break;
                case 4:
                    editor.displayText();
                    break;
                case 5:
                    System.out.println("Exiting editor.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
