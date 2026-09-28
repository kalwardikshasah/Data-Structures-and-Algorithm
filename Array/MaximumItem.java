import java.util.*;
public class MaximumItem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int n = sc.nextInt();
        String[] item = new String[n];
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            item[i] = sc.next();
            price[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (price[i] > price[j]) {
                    int temp = price[i];
                    price[i] = price[j];
                    price[j] = temp;
                    String tempItem = item[i];
                    item[i] = item[j];
                    item[j] = tempItem;
                }
            }
        }
        boolean bought = false;
        for (int i = 0; i < n; i++) {
            if (price[i] <= money) {
                System.out.println("I can afford " + item[i]);
                money -= price[i];
                bought = true;
            } else {
                System.out.println("I can't afford " + item[i]);
            }
        }
        if (!bought) {
            System.out.println("I need more Dollar!");
        }
        System.out.println(money);
        sc.close();
    }
}



