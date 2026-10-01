import java.util.Arrays;
import java.util.Scanner;
public class ArrayReductionQueries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextLong();
            }
            Arrays.sort(arr);
            long[] prefix = new long[n + 1];
            for (int i = 0; i < n; i++) {
                prefix[i + 1] = prefix[i] + arr[i];
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < q; i++) {
                int k = scanner.nextInt();
                long sumMiddle = prefix[n - 1] - prefix[k];
                long maxK = arr[n - 1] - (prefix[k] - prefix[0]);
                long result = sumMiddle + maxK;
                sb.append(result).append("\n");
            }
            System.out.print(sb.toString());
        }
        scanner.close();
    }
}


