import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int INF = 987654321;
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = INF;
        }
        dp[0] = 0;

        // DP 계산
        for (int i = 1; i <= N; i++) {
            if (i - 3 >= 0) {
                dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            }
            if (i - 5 >= 0) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
        }

        if (dp[N] >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
    }
}
