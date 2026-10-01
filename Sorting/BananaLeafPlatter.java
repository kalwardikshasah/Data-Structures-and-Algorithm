import java.util.Scanner;
public class BananaLeafPlatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                int p = scanner.nextInt();
                int[][] prefixSums = new int[n + 1][k + 1];
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= k; j++) {
                        int val = scanner.nextInt();
                        prefixSums[i][j] = prefixSums[i][j - 1] + val;
                    }
                }
                long[][] dp = new long[n + 1][p + 1];
                for (int i = 0; i <= n; i++) {
                    for (int j = 0; j <= p; j++) {
                        dp[i][j] = Long.MIN_VALUE;
                    }
                }
                dp[0][0] = 0;
                for (int i = 1; i <= n; i++) {
                    for (int j = 0; j <= p; j++) {
                        dp[i][j] = dp[i - 1][j];
                        for (int x = 1; x <= Math.min(j, k); x++) {
                            if (dp[i - 1][j - x] != Long.MIN_VALUE) {
                                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - x] + prefixSums[i][x]);
                            }
                        }
                    }
                }
                System.out.println(dp[n][p]);
            }
        }
        scanner.close();
    }
}



