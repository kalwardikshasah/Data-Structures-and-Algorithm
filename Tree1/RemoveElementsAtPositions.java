import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class RemoveElementsAtPositions {
    static class FenwickTree {
        int[] tree;
        int size;
        FenwickTree(int size) {
            this.size = size;
            this.tree = new int[size + 1];
        }
        void update(int idx, int delta) {
            while (idx <= size) {
                tree[idx] += delta;
                idx += idx & -idx;
            }
        }
        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += tree[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
        int findKth(int target) {
            int idx = 0;
            int bitMask = Integer.highestOneBit(size);
            while (bitMask != 0) {
                int nextIdx = idx + bitMask;
                if (nextIdx <= size && tree[nextIdx] < target) {
                    idx = nextIdx;
                    target -= tree[nextIdx];
                }
                bitMask >>= 1;
            }
            return idx + 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] positions = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            positions[i] = Integer.parseInt(st.nextToken());
        }
        FenwickTree fenwick = new FenwickTree(n);
        for (int i = 1; i <= n; i++) {
            fenwick.update(i, 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int targetPos = positions[i];
            int actualIndex = fenwick.findKth(targetPos);
            sb.append(arr[actualIndex]).append(" ");
            fenwick.update(actualIndex, -1);
        }
        System.out.println(sb.toString().trim());
        br.close();
    }
}


