import java.util.*;
public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        boolean balanced = true;
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            }
            else if (ch == ')' || ch == ']') {
                if (stack.isEmpty()) {
                    balanced = false;
                    break;
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[')) {
                    balanced = false;
                    break;
                }
            }
        }
        if (!stack.isEmpty()) {
            balanced = false;
        }
        if (balanced)
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");
        sc.close();
    }
}

