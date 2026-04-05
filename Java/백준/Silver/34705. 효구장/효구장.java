import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] meatWeight;
    static int sum, min, max;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            meatWeight = new int[5];
            sum = 0;
            
            st = new StringTokenizer(br.readLine());
            min = Integer.parseInt(st.nextToken());
            max = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<5; i++){
                meatWeight[i] = Integer.parseInt(st.nextToken());
            }

            if(canEnter(0, 0))
                sb.append("YES");
            else
                sb.append("NO");

            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    static boolean canEnter(int depth, int idx){
        if(sum > max)
            return false;
        
        if(sum >= min && sum <= max)
            return true;

        for(int i = idx; i<5; i++){
            if(sum >= max) continue;
            
            sum += meatWeight[i];

            if(canEnter(depth + 1, i + 1))
                return true;

            sum -= meatWeight[i];
        }

        return false;
    }
}