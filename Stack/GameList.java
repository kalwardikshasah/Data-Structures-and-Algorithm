import java.util.*;
public class GameList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            if (a[left] > a[right]) {
                System.out.print("1 ");
                left++;
            } else if (a[left] < a[right]) {
                System.out.print("2 ");
                right--;
            } else {
                System.out.print("0 ");
                left++;
                right--;
            }
        }
        sc.close();
    }
}