import java.util.*;
import java.lang.*;
import java.io.*;
// A일 때 B한 C값을 찾아라
// A : 현재 정수 x
// B : 
// C : x를 1, 2, 3의 합으로 표현하는 방법의 수
// 상태 : dp[x] = 합으로 나타내는 방법의 수
// 점화식 : dp[x] = dp[x-1] + dp[x-2] + dp[x-3]
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int[] dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
    
        for(int i = 4; i<11; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        int T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]);
            if(t<T-1) sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}