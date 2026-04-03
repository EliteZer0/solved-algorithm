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
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			if(m==0 && n==0) break;
			
			int totalCost = 0;
			
			parent = new int[m];
			pq = new PriorityQueue<>();
			
			for (int i = 0; i < m; i++) {
				parent[i] = i;
			}
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				
				totalCost += z;
				
				pq.offer(new Edge(x, y, z));
			}
			
			int min = kruskal(m);
			System.out.println(totalCost - min);
		}
	}

	private static int kruskal(int m) {
		int cost = 0;
		int edges = 0;
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(find(cur.from) != find(cur.to)) {
				union(cur.from, cur.to);
				cost += cur.weight;
				edges++;
			}
			
			if(edges == m-1) break;
		}
		
		return cost;
	}
}