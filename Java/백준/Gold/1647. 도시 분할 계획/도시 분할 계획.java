import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int from, to, weight;

	public Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
}

public class Main {
	static int[] parent;
	static PriorityQueue<Edge> pq;
	
	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x<y) parent[y] = x;
		else parent[x] = y;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
			
		parent = new int[N+1];
		pq = new PriorityQueue<>();
		
		for (int i = 0; i < N+1; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			pq.offer(new Edge(A, B, C));
		}
		
		int min = kruskal(N);
		
		System.out.println(min);
	}

	private static int kruskal(int n) {
		int cost = 0;
		int edges = 0;
		int maxWeight = 0;
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(find(cur.from) != find(cur.to)) {
				union(cur.from, cur.to);
				cost += cur.weight;
				maxWeight = Math.max(maxWeight, cur.weight);
				edges++;
			}
			
			if(edges == n-1) break;
		}
		
		return cost - maxWeight;
	}
}