import java.util.*;
public class SubMatrixSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int sum = 0;
            for (int i = x1 - 1; i <= x2 - 1; i++) {
                for (int j = y1 - 1; j <= y2 - 1; j++) {
                    sum += a[i][j];
                }
            }
            System.out.println(sum);
        }
        sc.close();
    }
}


