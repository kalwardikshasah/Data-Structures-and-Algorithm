import java.util.Arrays;
import java.util.Scanner;
public class EqualPopulationLine {
    static class Flat {
        int diff;
        int population;
        Flat(int x, int y, int h) {
            this.diff = y - x;
            this.population = h;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                int n = scanner.nextInt();
                Flat[] flats = new Flat[n];
                long totalPopulation = 0;
                for (int i = 0; i < n; i++) {
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    int h = scanner.nextInt();
                    flats[i] = new Flat(x, y, h);
                    totalPopulation += h;
                }
                if (totalPopulation % 2 != 0) {
                    System.out.println("NO");
                    continue;
                }
                Arrays.sort(flats, (a, b) -> Integer.compare(a.diff, b.diff));
                long currentSum = 0;
                boolean possible = false;
                long target = totalPopulation / 2;
                for (int i = 0; i < n; i++) {
                    currentSum += flats[i].population;
                    if (currentSum == target) {
                        possible = true;
                        break;
                    }
                }
                System.out.println(possible ? "YES" : "NO");
            }
        }
        scanner.close();
    }
}





