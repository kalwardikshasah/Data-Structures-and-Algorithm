import java.util.Scanner;
public class LatestStartDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                int n = scanner.nextInt();
                long d = scanner.nextLong();
                int[] x = new int[n];
                for (int i = 0; i < n; i++) {
                    x[i] = scanner.nextInt();
                }
                long currentDeadline = d;
                for (int i = n - 1; i >= 0; i--) {
                    long multiple = currentDeadline / x[i];
                    currentDeadline = multiple * x[i];
                }
                System.out.println(currentDeadline);
            }
        }
        scanner.close();
    }
}

