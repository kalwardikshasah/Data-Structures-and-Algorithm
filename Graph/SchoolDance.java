import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SchoolDance {

    static List<List<Integer>> adj;
    static int[] matchGirl;
    static boolean[] visited;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            // *** Bounds check: Ignore invalid edges where girl ID > m ***
            if (b >= 1 && b <= m) {
                adj.get(a).add(b);
            }
        }
        
        matchGirl = new int[m + 1];
        Arrays.fill(matchGirl, -1);
        
        int maxPairs = 0;
        
        for (int boy = 1; boy <= n; boy++) {
            visited = new boolean[m + 1];
            if (dfs(boy)) {
                maxPairs++;
            }
        }
        
        System.out.println(maxPairs);
        
        for (int girl = 1; girl <= m; girl++) {
            if (matchGirl[girl] != -1) {
                System.out.println(matchGirl[girl] + " " + girl);
            }
        }
        
        br.close();
    }
    
    private static boolean dfs(int boy) {
        for (int girl : adj.get(boy)) {
            if (girl > m) continue; // Safety check
            
            if (!visited[girl]) {
                visited[girl] = true;
                if (matchGirl[girl] == -1 || dfs(matchGirl[girl])) {
                    matchGirl[girl] = boy;
                    return true;
                }
            }
        }
        return false;
    }
}