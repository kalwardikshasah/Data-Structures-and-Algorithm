import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class PruferCodeDecoding {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        if (n == 2) {
            System.out.println("1 2");
            return;
        }
        int[] code = new int[n - 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 2; i++) {
            code[i] = Integer.parseInt(st.nextToken());
        }
        int[] degree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            degree[i] = 1;
        }
        for (int val : code) {
            degree[val]++;
        }
        PriorityQueue<Integer> leaves = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 1) {
                leaves.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 2; i++) {
            int leaf = leaves.poll(); 
            int parent = code[i];     
            sb.append(leaf).append(" ").append(parent).append("\n");
            degree[parent]--;
            if (degree[parent] == 1) {
                leaves.add(parent);
            }
        }
        int u = leaves.poll();
        int v = leaves.poll();
        sb.append(u).append(" ").append(v).append("\n");
        System.out.print(sb.toString());
        br.close();
    }
}


