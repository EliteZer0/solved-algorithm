import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 10007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int MAX = 52;
        int[][] C = new int[MAX + 1][MAX + 1];
        for (int n = 0; n <= MAX; n++) {
            C[n][0] = 1;
            C[n][n] = 1;
            for (int r = 1; r < n; r++) {
                C[n][r] = (C[n - 1][r - 1] + C[n - 1][r]) % MOD;
            }
        }

        int ans = 0;
        for (int k = 1; k <= 13; k++) {
            int used = 4 * k;
            if (used > N) break;

            int waysPickRanks = C[13][k];
            int waysPickRest = C[52 - used][N - used];
            int term = (waysPickRanks * waysPickRest) % MOD;

            if (k % 2 == 1) {
                ans += term;
            } else {
                ans -= term;
            }
            ans %= MOD;
        }

        if (ans < 0) ans += MOD;
        System.out.println(ans);
    }
}
