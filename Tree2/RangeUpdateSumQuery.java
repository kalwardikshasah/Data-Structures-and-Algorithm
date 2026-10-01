import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class RangeUpdateSumQuery {
    static long[] tree;
    static long[] lazyCoef;
    static long[] lazyConst;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        long[] arr = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        tree = new long[4 * n];
        lazyCoef = new long[4 * n];
        lazyConst = new long[4 * n];
        build(1, 1, n, arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (type == 1) {
                update(1, 1, n, a, b, 1, 1 - a);
            } else {
                long sum = query(1, 1, n, a, b);
                sb.append(sum).append("\n");
            }
        }
        System.out.print(sb.toString());
        br.close();
    }
    private static void build(int node, int start, int end, long[] arr) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(2 * node, start, mid, arr);
            build(2 * node + 1, mid + 1, end, arr);
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }
    private static void applyLazy(int node, int start, int end, long coef, long constant) {
        long sumIndices = (long)(start + end) * (end - start + 1) / 2;
        tree[node] += coef * sumIndices + constant * (end - start + 1);
        
        lazyCoef[node] += coef;
        lazyConst[node] += constant;
    }
    private static void pushDown(int node, int start, int end) {
        if (lazyCoef[node] != 0 || lazyConst[node] != 0) {
            int mid = (start + end) / 2;
            applyLazy(2 * node, start, mid, lazyCoef[node], lazyConst[node]);
            applyLazy(2 * node + 1, mid + 1, end, lazyCoef[node], lazyConst[node]);
            lazyCoef[node] = 0;
            lazyConst[node] = 0;
        }
    }
    private static void update(int node, int start, int end, int l, int r, long coef, long constant) {
        if (l > end || r < start) {
            return;
        }
        if (l <= start && end <= r) {
            applyLazy(node, start, end, coef, constant);
            return;
        }
        pushDown(node, start, end);
        int mid = (start + end) / 2;
        update(2 * node, start, mid, l, r, coef, constant);
        update(2 * node + 1, mid + 1, end, l, r, coef, constant);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }
    private static long query(int node, int start, int end, int l, int r) {
        if (l > end || r < start) {
            return 0;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        pushDown(node, start, end);
        int mid = (start + end) / 2;
        long p1 = query(2 * node, start, mid, l, r);
        long p2 = query(2 * node + 1, mid + 1, end, l, r);
        return p1 + p2;
    }
}