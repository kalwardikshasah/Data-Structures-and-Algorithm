import java.util.*;
class StackUsingQueue {
    Queue<Integer> q = new LinkedList<>();
    void push(int x) {
        int size = q.size();
        q.add(x);
        for (int i = 0; i < size; i++) {
            q.add(q.remove());
        }
    }
    int pop() {
        if (q.isEmpty())
            return -1;
        return q.remove();
    }
    int top() {
        if (q.isEmpty())
            return -1;
        return q.peek();
    }
}
public class StackUsingSingleQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        StackUsingQueue stack = new StackUsingQueue();
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }
        System.out.println("top of element " + stack.top());
        for (int i = 0; i < m; i++) {
            stack.pop();
        }
        System.out.println("top of element " + stack.top());
        sc.close();
    }
}


