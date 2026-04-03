import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i = 0; i<X; i++){
            sum += arr[i];
        }

        int max = sum;
        int cnt = 1;
        for(int i = X; i<N; i++){
            sum += (arr[i] - arr[i-X]);
            if(max<sum){
                max = sum;
                cnt = 1;
            }
            else if(max == sum) cnt ++;
        }
        
        if(max == 0) sb.append("SAD");
        else sb.append(max).append("\n").append(cnt);
        System.out.println(sb.toString());
    }
}