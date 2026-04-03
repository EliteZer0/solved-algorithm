import java.util.*;
import java.lang.*;
import java.io.*;

// A일 때 B한 C값을 찾아라
// A : 현재 좌표 r,c
// B : (r+1, c), (r, c+1), (r+1, c+1) 이동 중 선택
// C : N-1 M-1 좌표에 도달했을 때 먹을 수 있는 사탕의 최댓값
// 상태 : dp[r][c] = 왼쪽, 위, 대각선 왼쪽 위 중 최댓값 + 본인 칸
// 점화식 : dp[r][c] = Math.max(dp[r-1][c-1] , Math.max(dp[r-1][c], dp[r][c-1]));

class Main {    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 왼쪽, 위, 대각선 확인할 때 check 하기 싫어서 
        int[][] dp = new int[N+1][M+1];

        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=M; j++){
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=M; j++){
                dp[i][j] = Math.max(dp[i-1][j-1] , Math.max(dp[i-1][j], dp[i][j-1])) + dp[i][j];
            }
        }
        
        System.out.println(dp[N][M]);
    }
}