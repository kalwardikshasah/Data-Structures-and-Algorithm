import java.util.Scanner;
public class LargestBeautifulSubrectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();  
            while (t-- > 0) {
                int r = scanner.nextInt();
                int c = scanner.nextInt();
                int l = scanner.nextInt();               
                int[][] grid = new int[r][c];
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        grid[i][j] = scanner.nextInt();
                    }
                }
                int maxArea = 0;
                for (int c1 = 0; c1 < c; c1++) {
                    int[] minRow = new int[r];
                    int[] maxRow = new int[r];
                    for (int i = 0; i < r; i++) {
                        minRow[i] = grid[i][c1];
                        maxRow[i] = grid[i][c1];
                    }
                    for (int c2 = c1; c2 < c; c2++) {
                        for (int i = 0; i < r; i++) {
                            minRow[i] = Math.min(minRow[i], grid[i][c2]);
                            maxRow[i] = Math.max(maxRow[i], grid[i][c2]);
                        }
                        int top = 0;
                        for (int bottom = 0; bottom < r; bottom++) {
                            while (top <= bottom) {
                                int currentMin = Integer.MAX_VALUE;
                                int currentMax = Integer.MIN_VALUE;
                                for (int i = top; i <= bottom; i++) {
                                    currentMin = Math.min(currentMin, minRow[i]);
                                    currentMax = Math.max(currentMax, maxRow[i]);
                                }
                                if (currentMax - currentMin <= l) {
                                    break; 
                                }
                                top++;
                            }
                            int height = bottom - top + 1;
                            int width = c2 - c1 + 1;
                            maxArea = Math.max(maxArea, height * width);
                        }
                    }
                }
                System.out.println(maxArea);
            }
        }
        scanner.close();
    }
}


