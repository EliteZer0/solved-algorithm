import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] city;
    static int N, M;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        city = new int[N];
        int right = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            city[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, city[i]);
        }

        M = Integer.parseInt(br.readLine());

        int left = 1;
        int ans = 0;
        while(left <= right){
            int mid = (left+right)/2;
            
            if(check(mid)){
                ans = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }
        
        System.out.println(ans);
    }

    static boolean check(int x) {
        int sum = 0;
        
        for(int budget : city) {
            if(budget>x) sum += x;
            else sum += budget;
        }
        
        if(sum<=M) return true;
        
        return false;
    }
}