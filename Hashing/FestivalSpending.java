import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
public class FestivalSpending {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Map<String, List<Integer>> festivalMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                int amount = Integer.parseInt(st.nextToken());
                
                festivalMap.putIfAbsent(name, new ArrayList<>());
                festivalMap.get(name).add(amount);
            }
            String bestFestival = null;
            long maxSpending = -1;
            for (Map.Entry<String, List<Integer>> entry : festivalMap.entrySet()) {
                String name = entry.getKey();
                List<Integer> spendings = entry.getValue();
                Collections.sort(spendings, Collections.reverseOrder());
                long currentSum = 0;
                for (int i = 0; i < Math.min(3, spendings.size()); i++) {
                    currentSum += spendings.get(i);
                }
                if (currentSum > maxSpending) {
                    maxSpending = currentSum;
                    bestFestival = name;
                } else if (currentSum == maxSpending) {
                    if (name.compareTo(bestFestival) < 0) {
                        bestFestival = name;
                    }
                }
            }
            sb.append(bestFestival).append(" ").append(maxSpending).append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}

