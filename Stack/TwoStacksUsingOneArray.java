import java.util.*;
class TwoStacks {
    int[] arr;
    int top1;
    int top2;
    TwoStacks(int size) {
        arr = new int[size];
        top1 = -1;
        top2 = size;
    }
    void push1(int x) {
        if (top1 + 1 < top2) {
            arr[++top1] = x;
        }
    }
    void push2(int x) {
        if (top1 + 1 < top2) {
            arr[--top2] = x;
        }
    }
    int pop1() {
        if (top1 == -1)
            return -1;
        return arr[top1--];
    }
    int pop2() {
        if (top2 == arr.length)
            return -1;
        return arr[top2++];
    }
}
public class TwoStacksUsingOneArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TwoStacks stacks = new TwoStacks(5);
        for (int i = 0; i < 5; i++) {
            int x = sc.nextInt();
            if (i % 2 == 0)
                stacks.push1(x);
            else
                stacks.push2(x);
        }
        System.out.println("Popped element from stack1 is:" +stacks.pop1());
        System.out.println("Popped element from stack2 is:" +stacks.pop2());
        sc.close();
    }
}


