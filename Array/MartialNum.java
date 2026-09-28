import java.io.*;

public class MartialNum {
    static String martianNumeral(int n) {
        int[] values = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4, 1
        };
        String[] symbols = {
            "R", "BR", "G", "BG",
            "B", "ZB", "P", "ZP",
            "Z", "BK", "W", "BW", "B"
        };
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (n >= values[i]) {
                n -= values[i];
                result.append(symbols[i]);
            }
        }
        return result.toString();
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = 
           new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty())
                continue;
            int n = Integer.parseInt(line);
            System.out.println(martianNumeral(n));
        }
    }
}
