import java.util.*;

public class NumberSpelling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {
            "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE",
            "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE"
        };
        int[] count = new int[26];
        StringBuilder numbers = new StringBuilder();
        while (true) {
            int n = sc.nextInt();
            if (n == 999) {
                break;
            }
            numbers.append(n).append(" ");
            String word = names[n];
            for (char ch : word.toCharArray()) {
                count[ch - 'A']++;
            }
        }
        System.out.print(numbers + ". ");
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                System.out.print((char) ('A' + i) + " ");
                count[i]--;
            }
        }
        sc.close();
    }
} 
