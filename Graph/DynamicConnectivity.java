import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class DynamicConnectivity {
    static int[] parent;
    static int[] size; 
    static int numComponents;
    static int maxSize;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        numComponents = n;
        maxSize = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
            sb.append(numComponents).append(" ").append(maxSize).append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
    private static int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }
    private static void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            if (size[rootI] < size[rootJ]) {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
                if (size[rootJ] > maxSize) {
                    maxSize = size[rootJ];
                }
            } else {
                parent[rootJ] = rootI;
                size[rootI] += size[rootJ];
                if (size[rootI] > maxSize) {
                    maxSize = size[rootI];
                }
            }
            numComponents--;
        }
    }
}