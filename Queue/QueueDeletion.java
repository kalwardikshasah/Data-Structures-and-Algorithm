import java.util.*;
public class QueueDeletion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(sc.nextInt());
        }
        System.out.println("Dequeuing elements:");
        while (q.size() > 2) {
            q.remove();
            for (int x : q) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}

