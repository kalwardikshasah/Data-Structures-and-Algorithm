import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class DistinctValuesInConstructedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int MAX_I = 100000;
        List<Long> prefixSums = new ArrayList<>();
        prefixSums.add(0L);
        long currentSum = 0;
        for (int i = 1; i <= MAX_I; i++) {
            long count = (long) i * (long) Math.floor(Math.sqrt(i)) + (i + 1) / 2;
            currentSum += count;
            prefixSums.add(currentSum);
            if (currentSum > 1e13) {
                break; 
            }
        }
        if (scanner.hasNextInt()) {
            int q = scanner.nextInt();
            while (q-- > 0) {
                long l = scanner.nextLong();
                long r = scanner.nextLong();
                int leftIdx = binarySearchCeil(prefixSums, l);
                int rightIdx = binarySearchFloor(prefixSums, r);
                
                long distinctCount = rightIdx - leftIdx + 1;
                System.out.println(distinctCount);
            }
        }
        
        scanner.close();
    }
    private static int binarySearchCeil(List<Long> prefixSums, long target) {
        int low = 1;
        int high = prefixSums.size() - 1;
        int ans = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (prefixSums.get(mid) >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private static int binarySearchFloor(List<Long> prefixSums, long target) {
        int low = 0;
        int high = prefixSums.size() - 1;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (prefixSums.get(mid) < target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans + 1;
    }
}




