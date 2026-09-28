import java.util.*;
public class MatrixRowsColumns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        int[][] mat = new int[p][q];
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        boolean[] row = new boolean[p];
        boolean[] col = new boolean[q];
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                if (mat[i][j] == 1) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                if (row[i] || col[j]) {
                    mat[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}


