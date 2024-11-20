import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueWithLinkedList {

    public static void reverseFirstKElements(Queue<Integer> queue, int k) {
        if (queue.isEmpty() || k > queue.size() || k <= 0) {
            System.out.println("Invalid value of K.");
            return;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        int size = queue.size();
        for (int i = 0; i < size - k; i++) {
            queue.offer(queue.poll());
        }
    }

    public static void printQueue(Queue<Integer> queue) {
        System.out.println(queue);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);
        queue.offer(60);
        queue.offer(70);
        System.out.println("Original Queue:");
        printQueue(queue);

        int k = 4;
        System.out.println("Reversing the first " + k + " elements...");
        reverseFirstKElements(queue, k);

        System.out.println("Modified Queue:");
        printQueue(queue);
    }
}
