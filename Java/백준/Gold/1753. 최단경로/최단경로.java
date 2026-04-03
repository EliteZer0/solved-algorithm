import java.io.*;

import java.util.*;

public class Main {

    static class Edge {

        int to, w;

        Edge(int to, int w) { this.to = to; this.w = w; }

    }

    static class Node implements Comparable<Node> {

        int v;

        int dist;

        Node(int v, int dist) { this.v = v; this.dist = dist; }

        public int compareTo(Node o) { return Integer.compare(this.dist, o.dist); }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());

        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        List<Edge>[] g = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {

            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());

            int v = Integer.parseInt(st.nextToken());

            int w = Integer.parseInt(st.nextToken());

            g[u].add(new Edge(v, w));

        }

        final int INF = Integer.MAX_VALUE;

        int[] dist = new int[V + 1];

        Arrays.fill(dist, INF);

        dist[K] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(K, 0));

        while (!pq.isEmpty()) {

            Node cur = pq.poll();

            int now = cur.v;

            int d = cur.dist;

            // 이미 더 좋은 값으로 처리된 적 있으면 스킵 (핵심 최적화)

            if (d != dist[now]) continue;

            for (Edge e : g[now]) {

                int nd = d + e.w;

                if (nd < dist[e.to]) {

                    dist[e.to] = nd;

                    pq.add(new Node(e.to, nd));

                }

            }

        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= V; i++) {

            if (dist[i] == INF) sb.append("INF\n");

            else sb.append(dist[i]).append('\n');

        }

        System.out.print(sb.toString());

    }

}