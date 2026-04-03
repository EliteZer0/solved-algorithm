import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int r, c, w;

	public Node(int r, int c, int w) {
		super();
		this.r = r;
		this.c = c;
		this.w = w;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.w, o.w);
	}
}

public class Main {
	static int[][] dis, map;
	static boolean[][] visited;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int tc = 1;
		while(n != 0) {
			map = new int[n][n];
			dis = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dis[i][j] = Integer.MAX_VALUE;
				}
			}
			
			visited = new boolean[n][n];
			
			dijkstra(0, 0);
			
			int min = dis[n-1][n-1];
			StringBuilder sb = new StringBuilder();
			sb.append("Problem ").append(tc).append(": ").append(min);
			System.out.println(sb.toString());
			tc++;
			n = Integer.parseInt(br.readLine()); 
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	private static void dijkstra(int r, int c) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dis[r][c] = map[r][c];
		
		pq.add(new Node(r, c, map[r][c]));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.r][cur.c]) continue;
			visited[cur.r][cur.c] = true;
			
			for (int i = 0; i < 4; i++) {
				int mr = cur.r + dr[i];
				int mc = cur.c + dc[i];
				if(!check(mr, mc)) continue;
				
				if(dis[mr][mc]>dis[cur.r][cur.c]+map[mr][mc]) {
					dis[mr][mc] = dis[cur.r][cur.c]+map[mr][mc];
					pq.add(new Node(mr, mc, dis[mr][mc]));
				}
			}			
		}
	}
	private static boolean check(int r, int c) {
		return r>=0 && r<n && c>=0 && c<n;
	}
	
}