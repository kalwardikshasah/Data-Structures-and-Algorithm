import java.util.*;

public class MaximumProfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] price = new int[N];
            for (int i = 0; i < N; i++) {
                price[i] = sc.nextInt();
            }
            boolean found = false;
            int i = 0;
            while (i < N - 1) {
                while (i < N - 1 && price[i] >= price[i + 1]) {
                    i++;
                }
                if (i == N - 1) {
                    break;
                }
                int buy = i;
                i++;
                while (i < N && price[i] >= price[i - 1]) {
                    i++;
                }
                int sell = i - 1;
                System.out.print("(" + buy + " " + sell + ")");
                found = true;
            }
            if (!found) {
                System.out.println("No Profit");
            } else {
                System.out.println();
            }
        }
        sc.close();
    }
}

