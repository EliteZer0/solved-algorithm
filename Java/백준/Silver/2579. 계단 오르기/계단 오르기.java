import java.util.*;
import java.lang.*;
import java.io.*;
// A일 때 B한 C값을 찾아라
// A : 현재 정수 x
// B : x-2에서 2칸 이동, x-3에서 x-1을 거쳐 1칸 이동
// C : x칸에서의 최대 점수
// 상태 : dp[x] = x칸에서 얻을 수 있는 최대 점수
// 점화식 : dp[x] = Math.max(dp[x-3] + x-1 계단 점수 + x 계단 점수, dp[x-2] + x 계단 점수);
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] score = new int[n+1];

        for(int i = 1; i<=n; i++){
            score[i] = Integer.parseInt(br.readLine());
        }
        
        int[] dp = new int[n+1];

        dp[1] = score[1];
        if(n>=2) dp[2] = score[1] + score[2];
        if(n>=3) dp[3] = Math.max(dp[1] + score[3], score[2]+score[3]);
        
        for(int i = 4; i<=n; i++){
            dp[i] = Math.max(dp[i-2] + score[i], dp[i-3] + score[i-1] + score[i]);
        }
       
        System.out.println(dp[n]);
    }
}