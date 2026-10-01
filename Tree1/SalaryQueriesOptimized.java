import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
public class SalaryQueriesOptimized {
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
        int queryRange(int l, int r) {
            if (l > r) return 0;
            return query(r) - query(l - 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] salaries = new int[n + 1];
        List<Integer> allValues = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            salaries[i] = Integer.parseInt(st.nextToken());
            allValues.add(salaries[i]);
        }
        String[] queryTypes = new String[q];
        int[] queryParams1 = new int[q];
        int[] queryParams2 = new int[q];
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            queryTypes[i] = type;
            queryParams1[i] = Integer.parseInt(st.nextToken());
            queryParams2[i] = Integer.parseInt(st.nextToken());
            if (type.equals("!")) {
                allValues.add(queryParams2[i]);
            } else {
                allValues.add(queryParams1[i]);
                allValues.add(queryParams2[i]);
            }
        }
        int[] sortedUnique = allValues.stream().mapToInt(Integer::intValue).sorted().distinct().toArray();
        FenwickTree fenwick = new FenwickTree(sortedUnique.length);
        for (int i = 1; i <= n; i++) {
            int idx = Arrays.binarySearch(sortedUnique, salaries[i]) + 1;
            fenwick.update(idx, 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            if (queryTypes[i].equals("!")) {
                int k = queryParams1[i];
                int x = queryParams2[i];
                int oldIdx = Arrays.binarySearch(sortedUnique, salaries[k]) + 1;
                fenwick.update(oldIdx, -1);
                int newIdx = Arrays.binarySearch(sortedUnique, x) + 1;
                fenwick.update(newIdx, 1);
                salaries[k] = x;
            } else {
                int a = queryParams1[i];
                int b = queryParams2[i];
                int rightIdx = findFloorIndex(sortedUnique, b) + 1;
                int leftIdx = findFloorIndex(sortedUnique, a - 1) + 1;
                int count = fenwick.queryRange(leftIdx, rightIdx);
                sb.append(count).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
    private static int findFloorIndex(int[] sortedUnique, int target) {
        int low = 0;
        int high = sortedUnique.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortedUnique[mid] <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}



