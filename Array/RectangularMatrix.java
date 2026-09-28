import java.util.*; 

public class RectangularMatrix { 
   public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        int p = sc.nextInt();  
        int q = sc.nextInt();  
        for (int i = 0; i < p; i++) { 
            for (int j = 0; j < q; j++) { 
                int layer = Math.min( 
                    Math.min(i, p - 1 - i), 
                    Math.min(j, q - 1 - j) 
                ); 
                if (layer % 2 == 0) 
                    System.out.print("Y "); 
                else 
                    System.out.print("0 "); 
            } 
            System.out.println(); 
        } 
        sc.close(); 
    } 

}  
