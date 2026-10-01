import java.util.Arrays;
import java.util.Scanner;

public class ContinuousGreenSegment {

    static class Interval implements Comparable<Interval> {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            
            while (t-- > 0) {
                int n = scanner.nextInt();
                int l = scanner.nextInt();
                
                Interval[] intervals = new Interval[n];
                for (int i = 0; i < n; i++) {
                    intervals[i] = new Interval(scanner.nextInt(), scanner.nextInt());
                }
                
                Arrays.sort(intervals);
                boolean found = false;
                
                // Outer loop: Pick a starting interval
                for (int i = 0; i < n && !found; i++) {
                    int currentStart = intervals[i].start;
                    int currentEnd = intervals[i].end;
                    
                    // Check if the single interval itself is length L
                    if (currentEnd - currentStart == l) {
                        found = true;
                        break;
                    }
                    
                    // Inner loop: Try extending the segment with subsequent intervals
                    for (int j = i + 1; j < n; j++) {
                        // If the next interval overlaps or touches the current segment
                        if (intervals[j].start <= currentEnd) {
                            currentEnd = Math.max(currentEnd, intervals[j].end);
                            if (currentEnd - currentStart == l) {
                                found = true;
                                break;
                            }
                        } else {
                            // If it doesn't overlap, we can't extend this specific starting segment further
                            break;
                        }
                    }
                }
                
                System.out.println(found ? "Yes" : "No");
            }
        }
        
        scanner.close();
    }
}