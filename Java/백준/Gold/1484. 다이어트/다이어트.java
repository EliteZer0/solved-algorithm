import java.util.*;
import java.lang.*;
import java.io.*;

// G = cur^2 - memory^2
// = (cur+memory)(cur-memory)
// 15 = 15*1 -> cur = 8 memory = 7
// 15 = 5*3 -> cur = 4 memory = 1
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TreeSet<Integer> weight = new TreeSet<>();
        int G = Integer.parseInt(br.readLine());
        
        for(int i = 1; i*i<=G; i++){
            if (G%i != 0) continue;
            int cPm = G/i;
            if((cPm+i)%2 != 0) continue;
            int cur = (cPm+i)/2;
            int mem = (cPm-i)/2;
            if(mem > 0) weight.add(cur);
        }

        if (weight.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int x : weight) sb.append(x).append('\n');
            System.out.print(sb.toString());
        }
    }
}