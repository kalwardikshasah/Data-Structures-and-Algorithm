import java.util.Scanner;

public class MinimumPetrolRequired {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            
            while (t-- > 0) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                
                long totalExtraPetrol = 0;
                
                for (int i = 0; i < n; i++) {
                    int distance = scanner.nextInt();
                    // If the sub-track distance exceeds K, add the difference to the total
                    if (distance > k) {
                        totalExtraPetrol += (distance - k);
                    }
                }
                
                // If no extra petrol was needed, print -1, otherwise print the total
                if (totalExtraPetrol == 0) {
                    System.out.println("-1");
                } else {
                    System.out.println(totalExtraPetrol);
                }
            }
        }
        
        scanner.close();
    }
}


