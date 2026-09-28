import java.util.*;

public class MergedTwoStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] first = sc.nextLine().split(" ");
        String[] second = sc.nextLine().split(" ");
        for (int i = first.length - 1; i >= 0; i--) {
            System.out.print(first[i] + " ");
        }
        for (int i = second.length - 1; i >= 0; i--) {
            System.out.print(second[i] + " ");
        }
        sc.close();
    }
}

