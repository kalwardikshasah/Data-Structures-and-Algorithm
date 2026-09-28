import java.util.*;
public class PostfixToPrefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            }
            else {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String result = ch + operand1 + operand2;
                stack.push(result);
            }
        }
        System.out.println(stack.pop());
        sc.close();
    }
}


