import java.util.*;
public class QueueInsertion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        int n = sc.nextInt();
        while (n-- > 0) {
            int x = sc.nextInt();
            q.add(x);
            System.out.print("Enqueuing " + x + "\n");
            for (int a : q)
                System.out.print(a + " ");
            System.out.println();
        }
        sc.close();
    }
}


