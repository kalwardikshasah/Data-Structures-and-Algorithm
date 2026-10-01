import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class MaxSumSubarrayUniqueValues {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        
        // Step 1: Find Maximum Subarray Sum using Kadane's Algorithm
        long maxSum = Long.MIN_VALUE;
        long currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        
        // Step 2: Collect unique elements from all subarrays with sum == maxSum
        Set<Long> uniqueElements = new HashSet<>();
        
        // Iterate through all possible subarrays
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == maxSum) {
                    // Add all elements of this subarray to the set
                    for (int k = i; k <= j; k++) {
                        uniqueElements.add(arr[k]);
                    }
                }
            }
        }
        
        // Step 3: Calculate the sum of unique elements
        long result = 0;
        for (long val : uniqueElements) {
            result += val;
        }
        
        System.out.println(result);
        br.close();
    }
}