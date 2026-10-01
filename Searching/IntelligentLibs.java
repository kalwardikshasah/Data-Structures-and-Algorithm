import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class IntelligentLibs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String story = scanner.nextLine();
        List<String> nouns = new ArrayList<>();
        List<String> adverbs = new ArrayList<>();
        List<String> verbs = new ArrayList<>();
        List<String> adjectives = new ArrayList<>();
        String currentSection = "";
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.equals("END")) {
                break;
            }
            if (line.equals("NOUNS")) {
                currentSection = "NOUNS";
            } else if (line.equals("ADVERBS")) {
                currentSection = "ADVERBS";
            } else if (line.equals("VERBS")) {
                currentSection = "VERBS";
            } else if (line.equals("ADJECTIVES")) {
                currentSection = "ADJECTIVES";
            } else if (!line.isEmpty()) {
                switch (currentSection) {
                    case "NOUNS": nouns.add(line); break;
                    case "ADVERBS": adverbs.add(line); break;
                    case "VERBS": verbs.add(line); break;
                    case "ADJECTIVES": adjectives.add(line); break;
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            String result = story;
            result = result.replaceFirst("\\[N\\]", nouns.get(i));
            result = result.replaceFirst("\\[AV\\]", adverbs.get(i));
            result = result.replaceFirst("\\[V\\]", verbs.get(i));
            result = result.replaceFirst("\\[A\\]", adjectives.get(i));
            System.out.println(result);
        }
        scanner.close();
    }
}


