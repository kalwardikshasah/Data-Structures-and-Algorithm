import java.util.Scanner;
public class ForestQueries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            int[][] prefix = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                String row = scanner.next();
                for (int j = 1; j <= n; j++) {
                    int isTree = (row.charAt(j - 1) == '*') ? 1 : 0;
                    prefix[i][j] = isTree 
                                 + prefix[i - 1][j] 
                                 + prefix[i][j - 1] 
                                 - prefix[i - 1][j - 1];
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < q; i++) {
                int y1 = scanner.nextInt();
                int x1 = scanner.nextInt();
                int y2 = scanner.nextInt();
                int x2 = scanner.nextInt();
                int result = prefix[y2][x2] 
                           - prefix[y1 - 1][x2] 
                           - prefix[y2][x1 - 1] 
                           + prefix[y1 - 1][x1 - 1];          
                sb.append(result).append("\n");
            }
            System.out.print(sb.toString());
        }
        scanner.close();
    }
}



