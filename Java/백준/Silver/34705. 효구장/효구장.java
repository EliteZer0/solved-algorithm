import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] meatWeight;
    static boolean[] visited;
    static int sum, min, max;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            meatWeight = new int[5];
            visited = new boolean[5];
            sum = 0;
            
            st = new StringTokenizer(br.readLine());
            min = Integer.parseInt(st.nextToken());
            max = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<5; i++){
                meatWeight[i] = Integer.parseInt(st.nextToken());
            }

            if(canEnter(0))
                sb.append("YES");
            else
                sb.append("NO");

            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    static boolean canEnter(int depth){
        if(sum >= min && sum <= max)
            return true;

        for(int i = 0; i<5; i++){
            if(visited[i]) continue;
            if(sum >= max) continue;

            visited[i] = true;
            sum += meatWeight[i];

            if(canEnter(depth+1))
                return true;

            visited[i] = false;
            sum -= meatWeight[i];
        }

        return false;
    }
}