import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class BSequenceInsertion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int maxVal = -1;
        int maxIdx = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
                maxIdx = i;
            }
        }
        TreeSet<Integer> leftPart = new TreeSet<>();
        for (int i = 0; i < maxIdx; i++) {
            leftPart.add(arr[i]);
        }
        int currentMax = maxVal;
        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(st.nextToken());
            if (val > currentMax) {
                leftPart.add(currentMax);
                currentMax = val;
            } else if (val < currentMax) {
                if (!leftPart.contains(val)) {
                    leftPart.add(val);
                }
            }
            output.append(leftPart.size() * 2 + 1).append("\n");
        }
        StringBuilder finalSeq = new StringBuilder();
        for (int val : leftPart) {
            finalSeq.append(val).append(" ");
        }
        finalSeq.append(currentMax).append(" ");
        for (int val : leftPart.descendingSet()) {
            finalSeq.append(val).append(" ");
        }
        output.append(finalSeq.toString().trim());
        
        System.out.print(output.toString());
        br.close();
    }
}


