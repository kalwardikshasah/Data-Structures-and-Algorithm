import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
public class TreeIsomorphism {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            List<List<Integer>> adj1 = new ArrayList<>();
            for (int i = 0; i <= n; i++) adj1.add(new ArrayList<>());
            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adj1.get(u).add(v);
                adj1.get(v).add(u);
            }
            List<List<Integer>> adj2 = new ArrayList<>();
            for (int i = 0; i <= n; i++) adj2.add(new ArrayList<>());
            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adj2.get(u).add(v);
                adj2.get(v).add(u);
            }
            String form1 = getCanonicalForm(1, 0, adj1);
            String form2 = getCanonicalForm(1, 0, adj2);
            if (form1.equals(form2)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb.toString());
        br.close();
    }
    private static String getCanonicalForm(int u, int parent, List<List<Integer>> adj) {
        List<String> childrenForms = new ArrayList<>();
        
        for (int v : adj.get(u)) {
            if (v != parent) {
                childrenForms.add(getCanonicalForm(v, u, adj));
            }
        }
        Collections.sort(childrenForms);
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (String childForm : childrenForms) {
            sb.append(childForm);
        }
        sb.append(")");
        return sb.toString();
    }
}


