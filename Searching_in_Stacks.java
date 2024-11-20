import java.util.Scanner;
import java.util.Stack;

public class Searching_in_Stacks {
    public static int searchInStacks(Stack<Integer> stack, int element) {
        Stack<Integer> tempStack = new Stack<>();
        int position = -1; 
        int index = stack.size() - 1;  

        // Traverse through the stack
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (current == element) {
                position = index; 
            }
            tempStack.push(current);
            index--;  
        }

       
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        return position;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(11);
        stack.push(23);
        stack.push(34);
        stack.push(46);
        stack.push(57);

        System.out.println("Stack: " + stack);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the element: ");
        int element = scanner.nextInt();
        scanner.close();


        int position = searchInStacks(stack, element);

        if (position != -1) {
            System.out.println("Element " + element + " found at position " + position + " (from bottom of the stack).");
        } else {
            System.out.println("Element " + element + " not found in the stack.");
        }
    }
}
