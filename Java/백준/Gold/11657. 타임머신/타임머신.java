import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static class Edge {
        int from, to, w;
        Edge(int from, int to, int w){
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }

    static final long INF = Long.MAX_VALUE / 4;
    static int N, M;
    static ArrayList<Edge> edges;
    static long[] dist;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>(M);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges.add(new Edge(A, B, C));
        }

        dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i = 1; i <= N - 1; i++) {
            boolean updated = false;
            for (Edge e : edges) {
                if (dist[e.from] == INF) continue;
                long nd = dist[e.from] + e.w;
                if (dist[e.to] > nd) {
                    dist[e.to] = nd;
                    updated = true;
                }
            }
            if (!updated) break;
        }

        boolean negCycle = false;
        for (Edge e : edges) {
            if (dist[e.from] == INF) continue;
            if (dist[e.to] > dist[e.from] + e.w) {
                negCycle = true;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (negCycle) {
            sb.append("-1\n");
        } else {
            for (int v = 2; v <= N; v++) {
                sb.append(dist[v] == INF ? -1 : dist[v]).append('\n');
            }
        }
        System.out.print(sb.toString());
    }
}