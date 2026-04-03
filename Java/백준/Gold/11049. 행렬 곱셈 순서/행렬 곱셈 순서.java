import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] r = new int[N + 1];
        int[] c = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[N + 1][N + 1];
        long INF = Long.MAX_VALUE / 4;
        
        for (int len = 2; len <= N; len++) {
            for (int i = 1; i + len - 1 <= N; i++) {
                int j = i + len - 1;
                dp[i][j] = INF;

                for (int k = i; k < j; k++) {
                    long cost = dp[i][k] + dp[k + 1][j]
                              + (long) r[i] * c[k] * c[j];
                    if (cost < dp[i][j]) dp[i][j] = cost;
                }
            }
        }

        System.out.println(dp[1][N]);
    }
}