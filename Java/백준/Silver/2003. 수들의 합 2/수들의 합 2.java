import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        int[] prefix = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i-1] + arr[i];
        }

        int sum = 0;
        int cnt = 0;
        
        for(int i = 1; i<=N; i++){
            for(int j = 0; j<i; j++){
                sum = prefix[i] - prefix[j];
                if(sum == M) cnt++;
            }
        }

        System.out.println(cnt);
    }
}