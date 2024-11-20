import java.util.LinkedList;
import java.util.Queue;

public class QueueWithMinimum {

    public static int getMinimum(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        int min = Integer.MAX_VALUE;

        for (int value : queue) {
            min = Math.min(min, value);
        }

        return min;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(76);
        queue.offer(26);
        queue.offer(44);
        queue.offer(68);
        queue.offer(15);
        queue.offer(38);
        System.out.println("Queue: " + queue);
        System.out.println("Minimum Value in queue is : " + getMinimum(queue));
    }
}
