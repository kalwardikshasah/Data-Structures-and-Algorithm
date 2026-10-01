import java.util.Scanner;
public class CompanyHierarchy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            int logN = (int) (Math.log(n) / Math.log(2)) + 1;
            int[][] up = new int[n + 1][logN];
            for (int j = 0; j < logN; j++) {
                up[1][j] = 0;
            }
            for (int i = 2; i <= n; i++) {
                int boss = scanner.nextInt();
                up[i][0] = boss; 
            }
            for (int j = 1; j < logN; j++) {
                for (int i = 1; i <= n; i++) {
                    int intermediate = up[i][j - 1];
                    if (intermediate != 0) {
                        up[i][j] = up[intermediate][j - 1];
                    } else {
                        up[i][j] = 0;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < q; i++) {
                int x = scanner.nextInt();
                int k = scanner.nextInt();
                int current = x;
                int bit = 0;
                while (k > 0 && current != 0) {
                    if ((k & 1) == 1) {
                        current = up[current][bit];
                    }
                    k >>= 1;
                    bit++;
                }
                if (current == 0) {
                    sb.append("-1\n");
                } else {
                    sb.append(current).append("\n");
                }
            }
            System.out.print(sb.toString());
        }
        scanner.close();
    }
}




