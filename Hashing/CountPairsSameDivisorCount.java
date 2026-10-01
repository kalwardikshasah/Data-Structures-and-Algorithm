import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
public class CountPairsSameDivisorCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
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


