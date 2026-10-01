import java.util.Arrays;
import java.util.Scanner;
public class OrganizingContainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int q = scanner.nextInt();
            while (q-- > 0) {
                int n = scanner.nextInt();
                long[] rowSums = new long[n];
                long[] colSums = new long[n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        long val = scanner.nextLong();
                        rowSums[i] += val;
                        colSums[j] += val;
                    }
                }
                Arrays.sort(rowSums);
                Arrays.sort(colSums);
                boolean possible = true;
                for (int i = 0; i < n; i++) {
                    if (rowSums[i] != colSums[i]) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    System.out.println("Possible");
                } else {
                    System.out.println("Impossible");
                }
            }
        }
        scanner.close();
    }
}



