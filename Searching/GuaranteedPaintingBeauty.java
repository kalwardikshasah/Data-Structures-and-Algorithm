import java.util.Scanner;
public class GuaranteedPaintingBeauty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                int m = scanner.nextInt();
                String s = scanner.next();
                int[] beauty = new int[m];
                for (int i = 0; i < m; i++) {
                    beauty[i] = s.charAt(i) - '0';
                }
                int maxGuaranteed = 0;
                for (int i = 0; i < m; i++) {
                    for (int j = i; j < m; j++) {
                        int len = j - i + 1;
                        if (len >= 3) {
                            int left = i;
                            int right = j;
                            int totalSum = 0;
                            for (int k = i; k <= j; k++) {
                                totalSum += beauty[k];
                            }
                            int removedSum = 0;
                            for (int step = 0; step < 2; step++) {
                                if (beauty[left] < beauty[right]) {
                                    removedSum += beauty[left];
                                    left++;
                                } else {
                                    removedSum += beauty[right];
                                    right--;
                                }
                            }
                            int guaranteed = totalSum - removedSum;
                            if (guaranteed > maxGuaranteed) {
                                maxGuaranteed = guaranteed;
                            }
                        }
                    }
                }
                System.out.println(maxGuaranteed);
            }
        }
        scanner.close();
    }
}



