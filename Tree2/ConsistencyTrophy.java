import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class ConsistencyTrophy {
    static class Ghost implements Comparable<Ghost> {
        int age;
        int titles;
        Ghost(int age, int titles) {
            this.age = age;
            this.titles = titles;
        }
        @Override
        public int compareTo(Ghost other) {
            if (this.titles != other.titles) {
                return Integer.compare(other.titles, this.titles);
            }
            return Integer.compare(other.age, this.age);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); 
        int[] dailyWinners = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dailyWinners[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer, Integer> titleCounts = new HashMap<>();
        TreeSet<Ghost> sortedGhosts = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int age = dailyWinners[i];
            int currentTitles = titleCounts.getOrDefault(age, 0);
            
            if (currentTitles > 0) {
                sortedGhosts.remove(new Ghost(age, currentTitles));
            }
            int newTitles = currentTitles + 1;
            titleCounts.put(age, newTitles);
            sortedGhosts.add(new Ghost(age, newTitles));
            Ghost winner = sortedGhosts.first();
            sb.append(winner.age).append(" ").append(winner.titles).append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}


