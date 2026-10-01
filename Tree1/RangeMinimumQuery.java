import java.util.Scanner;
public class RangeMinimumQuery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int[] log = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                log[i] = log[i / 2] + 1;
            }
            int k = log[n] + 1;
            int[][] st = new int[n][k];
            for (int i = 0; i < n; i++) {
                st[i][0] = arr[i];
            }
            for (int j = 1; j < k; j++) {
                for (int i = 0; i + (1 << j) <= n; i++) {
                    st[i][j] = Math.min(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < q; i++) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                l--;
                r--;
                int j = log[r - l + 1];
                int minVal = Math.min(st[l][j], st[r - (1 << j) + 1][j]);
                sb.append(minVal).append("\n");
            }
            System.out.print(sb.toString());
        }
        scanner.close();
    }
}



