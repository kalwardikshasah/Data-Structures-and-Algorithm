import java.util.*;
public class NextGreaterSmaller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            int greater = -1;
            for (int j = i + 1; j < n; j++) {
                if (a[j] > a[i]) {
                    greater = j;
                    break;
                }
            }
            if (greater == -1) {
                System.out.print("-1 ");
                continue;
            }
            int smaller = -1;
            for (int j = greater + 1; j < n; j++) {
                if (a[j] < a[greater]) {
                    smaller = j;
                    break;
                }
            }
            if (smaller == -1) {
                System.out.print("-1 ");
            } else {
                System.out.print(a[smaller] + " ");
            }
        }
        sc.close();
    }
}

