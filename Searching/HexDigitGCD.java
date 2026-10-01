import java.util.Scanner;
public class HexDigitGCD {
    public static int getHexDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 16); 
            n /= 16;         
        }
        return sum;
    }
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int MAX_R = 100000;
        int[] prefixCount = new int[MAX_R + 1];
        int currentCount = 0;
        for (int i = 1; i <= MAX_R; i++) {
            int f_x = getHexDigitSum(i);
            if (gcd(i, f_x) > 1) {
                currentCount++;
            }
            prefixCount[i] = currentCount;
        }
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();        
            while (t-- > 0) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                int ans = prefixCount[r] - prefixCount[l - 1];
                System.out.println(ans);
            }
        }
        scanner.close();
    }
}


