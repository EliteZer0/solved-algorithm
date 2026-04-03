import java.util.*;
import java.lang.*;
import java.io.*;
// A일 때 B한 C값을 찾아라
// A : 현재 정수 x
// B : i를 안 마심, i만 마심 (i-1은 안 마심), i-1, i를 마심 (i-2는 안 마심)
// C : 최대 음주량
// 상태 : dp[x] = x칸에서 얻을 수 있는 최대 음주량
// 점화식 : dp[x] = max(dp[i-1], dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]);
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] wine = new int[n+1];
        for(int i = 1; i<=n; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }
        
        int[] dp = new int[n+1];

        dp[1] = wine[1];
        if (n >= 2) dp[2] = wine[1] + wine[2];

        for(int i = 3; i<=n; i++){
            dp[i] = Math.max(dp[i - 1],
                    Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
        } 
       
        System.out.println(dp[n]);
    }
}