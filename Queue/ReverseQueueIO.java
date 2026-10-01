import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
public class ReverseQueueIO {
    public static void reverseQueue(Queue<Integer> queue) {
        if (queue == null || queue.size() <= 1) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int size = sc.nextInt();
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                if (sc.hasNextInt()) {
                    queue.add(sc.nextInt());
                }
            }
            System.out.print("Queue:");
            for (Integer num : queue) {
                System.out.print(num + " ");
            }
            System.out.println(); 
            reverseQueue(queue);
            System.out.print("Reversed Queue:");
            for (Integer num : queue) {
                System.out.print(num + " ");
            }
            System.out.println(); 
        }
        sc.close();
    }
}



