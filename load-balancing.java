import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int cows = sc.nextInt();
        int maxLength = sc.nextInt();
        HashSet<Integer> vFence = new HashSet<>();
        HashSet<Integer> hFence = new HashSet<>();
        
        
        int[] x = new int[cows];
        int[] y = new int[cows];
        
        for (int i = 0; i < cows; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            vFence.add(x[i] + 1); //makes it even
            hFence.add(y[i] + 1);
        }
        int minMaxed = Integer.MAX_VALUE;

        for (int vert : vFence) {
            for (int horz : hFence) {
                int q1 = 0;
                int q2 = 0;
                int q3 = 0;
                int q4 = 0;
                    
                for (int i = 0; i < cows; i++) {
                    if (x[i] > vert && y[i] > horz) {
                        q1++;
                    }
                    else if (x[i] < vert && y[i] > horz) {
                        q2++;
                    }
                    else if (x[i] < vert && y[i] < horz) {
                        q3++;
                    }
                    else if (x[i] > vert && y[i] < horz) {
                        q4++;
                    }
                }
                int max = Math.max(Math.max(q1, q2), Math.max(q3, q4));
                minMaxed = Math.min(max, minMaxed);
            }
        }
        
        System.out.println(minMaxed);
    }
}
