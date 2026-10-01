import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class QueenGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        double phi = (1 + Math.sqrt(5)) / 2;
        double phiSq = phi * phi;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            int diff = b - a;
            int expectedA = (int) Math.floor(diff * phi);
            if (expectedA == a) {
                sb.append("sami\n");
            } else {
                sb.append("canthi\n");
            }
        }
        System.out.print(sb.toString());
        br.close();
    }
}
