import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumFrequencyRating {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read N, M, Q
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        // Read array
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // Find max value to size our array
        int maxVal = 0;
        for (int val : arr) {
            maxVal = Math.max(maxVal, val);
        }
        // Add buffer for Q*M operations
        int limit = maxVal + q * m + 1;
        
        // Frequency array
        int[] freq = new int[limit + 1];
        for (int val : arr) {
            freq[val]++;
        }
        
        int maxRating = 0;
        
        // For each residue class modulo M
        for (int r = 0; r < m; r++) {
            // Sliding window of size 2*Q + 1
            int windowSize = 2 * q + 1;
            int currentSum = 0;
            
            // Initialize first window
            for (int i = 0; i < windowSize; i++) {
                int val = r + i * m;
                if (val <= limit) {
                    currentSum += freq[val];
                }
            }
            maxRating = Math.max(maxRating, currentSum);
            
            // Slide window
            for (int start = 1; ; start++) {
                int removeVal = r + (start - 1) * m;
                int addVal = r + (start + windowSize - 1) * m;
                
                if (addVal > limit) break;
                
                currentSum -= freq[removeVal];
                currentSum += freq[addVal];
                maxRating = Math.max(maxRating, currentSum);
            }
        }
        
        System.out.println(maxRating);
        br.close();
    }
}
