import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("cownomics.in"));
        int typeNum = sc.nextInt();
        int letters = sc.nextInt();

        String[] genome = new String[typeNum * 2];
        
        for (int i = 0; i < typeNum * 2; i++) {
            genome[i] = sc.next();
        }
        sc.close();
        
        int counter = 0;
        
        for (int i = 0; i < letters; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            boolean good = true;
            
            for (int j = 0; j < typeNum; j++) {
                if (map.get(genome[j].charAt(i)) == null) {
                    map.put(genome[j].charAt(i), 1);
                }
            }
            for (int j = typeNum; j < typeNum * 2; j++) {
                if (map.get(genome[j].charAt(i)) != null) {
                    good = false;
                    break;
                }
            }
            
            if (good) {
                counter++;
            }
        }

        PrintWriter out = new PrintWriter(new File("cownomics.out"));
        out.println(counter);
        out.close();
    }
}
