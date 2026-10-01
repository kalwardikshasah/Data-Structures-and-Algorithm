import java.util.Scanner;
public class ThirdLargestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int first = Integer.MIN_VALUE;
            int second = Integer.MIN_VALUE;
            int third = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int num = arr[i];
                if (num > first) {
                    third = second;
                    second = first;
                    first = num;
                } 
                else if (num > second && num != first) {
                    third = second;
                    second = num;
                } 
                else if (num > third && num != second && num != first) {
                    third = num;
                }
            }
            System.out.println("The third Largest element is " + third);
        }
        scanner.close();
    }
}



