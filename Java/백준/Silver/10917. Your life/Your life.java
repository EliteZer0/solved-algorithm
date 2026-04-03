import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        dist[1] = 0;
        q.add(1);

        while (!q.isEmpty()) {
            int v = q.poll();
            if (v == N) break;

            for (int to : adj[v]) {
                if (dist[to] != -1) continue;
                dist[to] = dist[v] + 1;
                q.add(to);
            }
        }

        System.out.println(dist[N]);
    }
}