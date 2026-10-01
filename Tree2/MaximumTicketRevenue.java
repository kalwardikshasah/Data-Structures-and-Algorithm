import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class MaximumTicketRevenue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            maxHeap.add(Integer.parseInt(st.nextToken()));
        }
        long totalRevenue = 0;
        for (int i = 0; i < n; i++) {
            int currentMax = maxHeap.poll();
            totalRevenue += currentMax;
            if (currentMax - 1 > 0) {
                maxHeap.add(currentMax - 1);
            }
        }
        System.out.println(totalRevenue);
        br.close();
    }
}


