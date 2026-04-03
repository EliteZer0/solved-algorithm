import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K + 1];

        Arrays.fill(dp, Integer.MAX_VALUE / 4);
        dp[A] = 0;

        for (int x = A + 1; x <= K; x++) {
            dp[x] = Math.min(dp[x], dp[x - 1] + 1);

            if (x % 2 == 0) {
                dp[x] = Math.min(dp[x], dp[x / 2] + 1);
            }
        }

        System.out.println(dp[K]);
    }
}
