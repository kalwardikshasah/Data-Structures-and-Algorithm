import java.util.*;
public class GemstoneSorting {
    private static final List<String> GEMSTONE_RANKING = Arrays.asList(
        "Lapis", "Topaz", "Tourmaline", "Sapphire", "Peridot", 
        "Ruby", "Pearl", "Emerald", "Diamond", "Aquamarine", 
        "Amethyst", "Garnet"
    );
    static class Horse implements Comparable<Horse> {
        String name;
        int highestGemRank; 
        Horse(String name) {
            this.name = name;
            this.highestGemRank = findHighestGemRank(name);
        }
        private int findHighestGemRank(String name) {
            String[] words = name.split(" ");
            int bestRank = Integer.MAX_VALUE;
            for (String word : words) {
                int rank = GEMSTONE_RANKING.indexOf(word);
                if (rank != -1 && rank < bestRank) {
                    bestRank = rank;
                }
            }
            return (bestRank == Integer.MAX_VALUE) ? -1 : bestRank;
        }
        @Override
        public int compareTo(Horse other) {
            if (this.highestGemRank != -1 && other.highestGemRank == -1) return -1;
            if (this.highestGemRank == -1 && other.highestGemRank != -1) return 1;
            if (this.highestGemRank != -1 && other.highestGemRank != -1) {
                if (this.highestGemRank != other.highestGemRank) {
                    return Integer.compare(this.highestGemRank, other.highestGemRank);
                }
            }
            return this.name.compareToIgnoreCase(other.name);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Horse> horses = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.equals("END")) {
                break;
            }
            if (!line.isEmpty()) {
                horses.add(new Horse(line));
            }
        }
        Collections.sort(horses);
        for (Horse horse : horses) {
            System.out.println(horse.name);
        }
        scanner.close();
    }
}



