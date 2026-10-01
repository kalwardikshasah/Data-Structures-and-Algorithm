import java.util.Scanner;
public class MissingVariableSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double m = 0, d = 0, x = 0;
        boolean mMissing = false, dMissing = false, xMissing = false;
        for (int i = 0; i < 3; i++) {
            if (scanner.hasNext()) {
                String variable = scanner.next(); 
                String valueStr = scanner.next(); 
                if (valueStr.equals("?")) {
                    if (variable.equals("M")) mMissing = true;
                    else if (variable.equals("D")) dMissing = true;
                    else if (variable.equals("X")) xMissing = true;
                } else {
                    double value = Double.parseDouble(valueStr);
                    if (variable.equals("M")) m = value;
                    else if (variable.equals("D")) d = value;
                    else if (variable.equals("X")) x = value;
                }
            }
        }
        if (xMissing) {
            x = m / -d;
            System.out.printf("X %.2f\n", x);
        } else if (mMissing) {
            m = -d * x;
            System.out.printf("M %.2f\n", m);
        } else if (dMissing) {
            d = m / -x;
            System.out.printf("D %.2f\n", d);
        }
        scanner.close();
    }
}



