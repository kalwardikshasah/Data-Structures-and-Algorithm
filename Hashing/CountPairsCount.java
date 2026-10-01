import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
public class CountPairsCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }
        int n = Integer.parseInt(line.trim());
        int[] arr = new int[n];
        int idx = 0;
        while (idx < n) {
            line = br.readLine();
            if (line == null) break;
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens() && idx < n) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }
        }
        int maxVal = 0;
        for (int val : arr) {
            if (val > maxVal) maxVal = val;
        }
        int[] divCount = new int[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            for (int j = i; j <= maxVal; j += i) {
                divCount[j]++;
            }
        }
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int count = divCount[arr[i]];
            freqMap.put(count, freqMap.getOrDefault(count, 0) + 1);
        }
        long totalPairs = 0;
        for (int freq : freqMap.values()) {
            totalPairs += (long) freq * (freq - 1) / 2;
        }
        System.out.println(totalPairs);
        br.close();
    }
}

