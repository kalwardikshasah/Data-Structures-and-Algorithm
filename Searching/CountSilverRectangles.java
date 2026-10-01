import java.util.Scanner;
public class CountSilverRectangles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int silverCount = 0;
            for (int i = 0; i < n; i++) {
                long w = scanner.nextLong();
                long h = scanner.nextLong();
                long maxSide = Math.max(w, h);
                long minSide = Math.min(w, h);
                if (16 * minSide <= 10 * maxSide && 10 * maxSide <= 17 * minSide) {
                    silverCount++;
                }
            }
            System.out.println(silverCount);
        }
        scanner.close();
    }
}


