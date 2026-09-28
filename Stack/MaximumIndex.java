import java.util.*;
public class MaximumIndex {
    static int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] A = new int[N];
        int[] sum = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            sum[i] = digitSum(A[i]);
        }
        while (Q-- > 0) {
            int x = sc.nextInt();
            int ans = -1;
            for (int i = x; i < N; i++) {
                if (A[i] > A[x - 1] &&
                    sum[i] < sum[x - 1]) {
                    ans = i + 1;
                    break;
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }
}


