import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int[] prices;
    static int[][] discount;

    static boolean[] bought;
    static int[] curDisc;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine().trim());

        prices = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) prices[i] = Integer.parseInt(st.nextToken());

        discount = new int[N][N];

        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(br.readLine().trim());
            for (int j = 0; j < p; j++) {
                st = new StringTokenizer(br.readLine());
                int t = Integer.parseInt(st.nextToken()) - 1;
                int d = Integer.parseInt(st.nextToken());
                discount[i][t] = d;
            }
        }

        bought = new boolean[N];
        curDisc = new int[N];

        dfs(0, 0);

        System.out.println(ans);
    }

    // cnt는 지금까지 산 물약 개수, cost는 지금까지 낸 비용
    static void dfs(int cnt, int cost) {
        if (cost >= ans) return;
        if (cnt == N) {
            ans = Math.min(ans, cost);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (bought[i]) continue;

            // i번 물약을 지금 살 때 가격
            int pay = prices[i] - curDisc[i];
            if (pay < 1) pay = 1;

            bought[i] = true;

            // i를 구매함으로써 추가되는 할인 적용 (되돌리기 위해 변경된 target만 기록)
            int[] changedTargets = new int[N];
            int changedCnt = 0;

            for (int t = 0; t < N; t++) {
                int d = discount[i][t];
                if (d != 0) {
                    curDisc[t] += d;
                    changedTargets[changedCnt++] = t;
                }
            }

            dfs(cnt + 1, cost + pay);

            // 할인 되돌리기
            for (int idx = 0; idx < changedCnt; idx++) {
                int t = changedTargets[idx];
                curDisc[t] -= discount[i][t];
            }

            bought[i] = false;
        }
    }
}