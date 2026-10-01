import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class CrushCrush {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] boyCrush = new int[n + 1]; 
            int[] girlCrush = new int[n + 1]; 
            
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                boyCrush[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                girlCrush[i] = Integer.parseInt(st.nextToken());
            }
            int totalNodes = 2 * n;
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= totalNodes; i++) {
                adj.add(new ArrayList<>());
            }
            for (int x = 1; x <= n; x++) {
                int y = boyCrush[x]; // Girl y
                int z = girlCrush[y]; // Boy z
                adj.get(x).add(z); // Boy x beats up Boy z
            }
            for (int y = 1; y <= n; y++) {
                int z = girlCrush[y]; 
                int x = boyCrush[z]; 
                adj.get(n + y).add(n + x); 
            }
            int[] inDegree = new int[totalNodes + 1];
            for (int u = 1; u <= totalNodes; u++) {
                for (int v : adj.get(u)) {
                    inDegree[v]++;
                }
            }
            int maxBeatings = 0;
            for (int i = 1; i <= totalNodes; i++) {
                if (inDegree[i] > maxBeatings) {
                    maxBeatings = inDegree[i];
                }
            }
            int mutualCount = 0;
            for (int x = 1; x <= n; x++) {
                for (int z : adj.get(x)) {
                    // Check if z beats x
                    boolean beatsBack = false;
                    for (int w : adj.get(z)) {
                        if (w == x) {
                            beatsBack = true;
                            break;
                        }
                    }
                    if (beatsBack) {
                        mutualCount++;
                    }
                }
            }
            for (int y = n + 1; y <= totalNodes; y++) {
                for (int x : adj.get(y)) {
                    boolean beatsBack = false;
                    for (int w : adj.get(x)) {
                        if (w == y) {
                            beatsBack = true;
                            break;
                        }
                    }
                    if (beatsBack) {
                        mutualCount++;
                    }
                }
            }
            mutualCount /= 2;
            sb.append(maxBeatings).append(" ").append(mutualCount).append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}



