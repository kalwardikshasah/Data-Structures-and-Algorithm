import java.util.*;
public class ProductOfTopThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(a[i]);
            if (pq.size() > 3) {
                pq.poll();
            }
            if (pq.size() < 3) {
                System.out.print("-1 ");
            } else {
                long product = 1;
                for (long x : pq) {
                    product *= x;
                }
                System.out.print(product + " ");
            }
        }
        sc.close();
    }
}




