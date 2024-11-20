class Stack {
    private final int[] stack;
    private int top;
    private final int capacity;

    // Constructor
    public Stack(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = -1;
    }

    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack overflow! Cannot push " + element);
            return;
        }
        stack[++top] = element; 
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow! Cannot pop.");
            return -1; 
        }
        return stack[top--]; 
    }

  
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Nothing to peek.");
            return -1; 
        }
        return stack[top]; 
    }

    public boolean isEmpty() {
        return top == -1;
    }

  
    public boolean isFull() {
        return top == capacity - 1;
    }

   
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}


public class Stack1 {
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.printStack(); 

        System.out.println("Top element is: " + stack.peek());

        stack.pop();
        stack.printStack();

        System.out.println("Top element is: " + stack.peek());
    }
}
