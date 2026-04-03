import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int v, w;

	public Node(int v, int w) {
		super();
		this.v = v;
		this.w = w;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.w, o.w);
	}
}

public class Main {
	static ArrayList<Node>[] adjList;
	static int[] dis;
	static boolean[] visited;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int infectionPC = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList[n+1];
			dis = new int[n+1];
			visited = new boolean[n+1];
			
			for (int i = 1; i < n+1; i++) {
				dis[i] = Integer.MAX_VALUE;
				adjList[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				adjList[b].add(new Node(a, s));
			}
			
			dijkstra(infectionPC);
			
			int visitCount = 0;
			int maxTime = 0;
			
			for (int i = 1; i < n+1; i++) {
			    if (dis[i] != Integer.MAX_VALUE) {
			        visitCount++;
			        maxTime = Math.max(maxTime, dis[i]);
			    }
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append(visitCount).append(" ").append(maxTime);
			System.out.println(sb.toString());
		}
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dis[start] = 0;
		
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.v]) continue;
			visited[cur.v] = true;
			
			for (Node node : adjList[cur.v]) {
				if(dis[node.v]>dis[cur.v]+node.w) {
					dis[node.v] = dis[cur.v]+node.w;
					pq.add(new Node(node.v, dis[node.v]));
				}
			}
		}
	}
}