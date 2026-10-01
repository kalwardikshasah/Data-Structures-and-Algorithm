import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class MatchMaking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                int n = scanner.nextInt();
                Integer[] girls = new Integer[n];
                for (int i = 0; i < n; i++) {
                    girls[i] = scanner.nextInt();
                }
                Integer[] boys = new Integer[n];
                for (int i = 0; i < n; i++) {
                    boys[i] = scanner.nextInt();
                }
                Arrays.sort(girls);
                Arrays.sort(boys, Collections.reverseOrder());
                int idealPairs = 0;
                for (int i = 0; i < n; i++) {
                    int girlHeight = girls[i];
                    int boyHeight = boys[i];
                    if (girlHeight % boyHeight == 0 || boyHeight % girlHeight == 0) {
                        idealPairs++;
                    }
                }
                System.out.println(idealPairs);
            }
        }
        scanner.close();
    }
}




