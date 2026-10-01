import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class MinimumScalarProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                int n = scanner.nextInt();
                Integer[] a = new Integer[n];
                for (int i = 0; i < n; i++) {
                    a[i] = scanner.nextInt();
                }
                Integer[] b = new Integer[n];
                for (int i = 0; i < n; i++) {
                    b[i] = scanner.nextInt();
                }
                Arrays.sort(a);
                Arrays.sort(b, Collections.reverseOrder());
                long minSum = 0;
                for (int i = 0; i < n; i++) {
                    minSum += (long) a[i] * b[i];
                }
                System.out.println(minSum);
            }
        }
        scanner.close();
    }
}


