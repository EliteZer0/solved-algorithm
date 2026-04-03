import java.util.*;
import java.lang.*;
import java.io.*;

/*
처음엔 두 문자열을 비교해서 LCS를 구하고,
그 LCS와 나머지 한 문자열을 비교하려 했는데
이 경우의 반례가 몇가지 있어 3차원 디피로 접근
dp[i][j][t] = A의 앞 i글자, B의 앞 j글자, C의 앞 t글자에서의 LCS 길이
세 문자의 마지막이 모두 같으면
dp[i][j][t] = dp[i-1][j-1][t-1] + 1
아니면
dp[i][j][t] = max(dp[i-1][j][t], dp[i][j-1][t], dp[i][j][t-1])
*/
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();

        int n = A.length();
        int m = B.length();
        int k = C.length();
        int[][][] dp = new int[n+1][m+1][k+1];
        
        for (int i = 1; i <= n; i++) {
            char a = A.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                char b = B.charAt(j - 1);
                for (int t = 1; t <= k; t++) {
                    char c = C.charAt(t - 1);

                    if (a == b && b == c) {
                        dp[i][j][t] = dp[i - 1][j - 1][t - 1] + 1;
                    } else {
                        dp[i][j][t] = Math.max(
                                dp[i - 1][j][t],
                                Math.max(dp[i][j - 1][t], dp[i][j][t - 1])
                        );
                    }
                }
            }
        }

        System.out.println(dp[n][m][k]);
    }
}