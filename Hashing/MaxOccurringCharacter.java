import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class MaxOccurringCharacter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (str == null || str.isEmpty()) {
            return;
        }
        int[] count = new int[256];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        char maxChar = 0;
        int maxCount = 0;
        for (int i = 0; i < 256; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                maxChar = (char) i;
            }
        }
        System.out.println(maxChar + " " + maxCount);
        
        br.close();
    }
}


