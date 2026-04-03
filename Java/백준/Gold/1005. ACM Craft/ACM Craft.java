import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] D = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) D[i] = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

            int[] indeg = new int[N + 1];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph[X].add(Y);
                indeg[Y]++;
            }

            int W = Integer.parseInt(br.readLine());

            int[] dp = new int[N + 1];
            ArrayDeque<Integer> q = new ArrayDeque<>();

            for (int i = 1; i <= N; i++) {
                if (indeg[i] == 0) {
                    dp[i] = D[i];
                    q.add(i);
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int nxt : graph[cur]) {
                    dp[nxt] = Math.max(dp[nxt], dp[cur] + D[nxt]);

                    if (--indeg[nxt] == 0) {
                        q.add(nxt);
                    }
                }
            }

            sb.append(dp[W]).append('\n');
        }

        System.out.print(sb);
    }
}
