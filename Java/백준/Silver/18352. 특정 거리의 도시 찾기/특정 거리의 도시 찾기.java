import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static class Node implements Comparable<Node>{
        int to;
        int cost;

        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int N, M, K, X;
    static List<Node>[] graph;
    static int[] dist;
    static final int INF = 987654321;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(new Node(B, 1)); // 가중치 1
        }

        dist = new int[N + 1];
        dijkstra(X);

        StringBuilder sb = new StringBuilder();
        boolean found = false;

        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                sb.append(i).append('\n');
                found = true;
            }
        }

        if (!found) sb.append(-1).append('\n');
        System.out.print(sb.toString());
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, INF);
    
        dist[start] = 0;
        pq.offer(new Node(start, 0));
    
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.cost > dist[cur.to]) continue;
    
            for (Node next : graph[cur.to]) {
                int newDist = dist[cur.to] + next.cost;
    
                if (newDist < dist[next.to]) {
                    dist[next.to] = newDist;
                    pq.offer(new Node(next.to, newDist));
                }
            }
        }
    }
}