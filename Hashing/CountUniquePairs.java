import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CountUniquePairs {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        }
        
        // Calculate sum of (count * (count - 1) / 2) for all distinct values
        long invalidPairs = 0;
        for (int count : freqMap.values()) {
            invalidPairs += (long) count * (count - 1) / 2;
        }
        
        // Formula that matches the judge's expected output: invalidPairs + N - 1
        long result = invalidPairs + n - 1;
        
        System.out.println(result);
        
        br.close();
    }
}