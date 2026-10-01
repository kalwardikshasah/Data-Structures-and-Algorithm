import java.util.Arrays;
import java.util.Scanner;
public class LaptopSale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                int n = scanner.nextInt();
                int m = scanner.nextInt();
                int[] prices = new int[n];
                for (int i = 0; i < n; i++) {
                    prices[i] = scanner.nextInt();
                }
                Arrays.sort(prices);
                long maxEarnings = 0;
                for (int i = 0; i < m && i < n; i++) {
                    if (prices[i] < 0) {
                        maxEarnings += Math.abs(prices[i]);
                    } else {
                        break;
                    }
                }
                System.out.println(maxEarnings);
            }
        }
        scanner.close();
    }
}







