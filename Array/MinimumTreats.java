import java.util.*;
public class MinimumTreats {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] size = new int[n];
            for (int i = 0; i < n; i++) {
                size[i] = sc.nextInt();
            }
            Arrays.sort(size);
            int treats = 1;
            int sum = 0;
            sum += treats;
            for (int i = 1; i < n; i++) {
                if (size[i] != size[i - 1]) {
                    treats++;
                }
                sum += treats;
            }
            System.out.println(sum);
        }
        sc.close();
    }
}


