import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class DynamicArraySetQuery {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        TreeSet<Integer> set = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int k = Integer.parseInt(st.nextToken());
                set.add(k);
            } else {
                int y = Integer.parseInt(st.nextToken());
                Integer result = set.ceiling(y);
                if (result == null) {
                    sb.append("-1\n");
                } else {
                    sb.append(result).append("\n");
                }
            }
        }
        System.out.print(sb.toString());
        br.close();
    }
}


