import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static class Edge {
        int to, w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }

    static class Node implements Comparable<Node> {
        int v, dist;
        Node(int v, int dist) { this.v = v; this.dist = dist; }
        public int compareTo(Node o) { return Integer.compare(this.dist, o.dist); }
    }

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Edge>[] g = new ArrayList[N + 1];
        List<Edge>[] rg = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
            rg[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            g[u].add(new Edge(v, w));
            rg[v].add(new Edge(u, w));
        }

        int[] distFromX = dijkstra(g, X);   // X -> i
        int[] distToX   = dijkstra(rg, X);  // i -> X

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, distFromX[i] + distToX[i]);
        }
        System.out.println(ans);
    }

        static int[] dijkstra(List<Edge>[] graph, int start) {
        int n = graph.length - 1;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.dist != dist[cur.v]) continue;

            for (Edge e : graph[cur.v]) {
                int nd = cur.dist + e.w;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    pq.add(new Node(e.to, nd));
                }
            }
        }
        return dist;
    }
}