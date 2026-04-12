import java.util.*;
import java.lang.*;
import java.io.*;

/*
 '.' (점)은 빈 필드를 의미하며, 글자 '#'는 울타리를, 'o'는 양, 'v'는 늑
영역 안의 양의 수 > 늑대의 수 늑대 제거
영역 안의 양의 수 <= 늑대의 수 영역 안의 모든 양 제거
*/
class Area {
    int sheep, wolf;

    Area(int sheep, int wolf){
        this.sheep = sheep;
        this.wolf = wolf;
    }
}

class Coordinate {
    int r, c;

    Coordinate(int r, int c){
        this.r = r;
        this.c = c;
    }
}

/*
각 영역마다 체크를 위해서 맵에서 bfs를 여러번 돌려야함.
영역을 판단하는 기준이 어려워서 visited 배열을 통해서 이미 체크된 영역은 패스하는 형태를 이용해서
bfs 끊어지면 다음 bfs를 찾으러 가는 형태가 되어야할 듯?
*/
class Main {
    static boolean[][] visited;
    static char[][] board;
    static int n, m, surviveSheep, surviveWolf;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n][m];
        board = new char[n][m];
		
		for(int i = 0; i < n; i++) {
			board[i] = br.readLine().toCharArray();
		}
        
		surviveSheep = 0;
        surviveWolf = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
                if(board[i][j] != '#' && !visited[i][j])
                    bfs(i, j);
			}
		}
		
		sb.append(surviveSheep).append(' ').append(surviveWolf);
		System.out.print(sb.toString());
	}

    static boolean check(int r, int c){
        return r>=0 && r<n && c>=0 && c<m;
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void bfs(int r, int c){
        Queue<Coordinate> que = new LinkedList<>();
        que.offer(new Coordinate(r, c));
        visited[r][c] = true;
        Area curArea = new Area(0, 0);
        
        while(!que.isEmpty()){
            Coordinate cur = que.poll();
            int cr = cur.r;
            int cc = cur.c;

            if(board[cr][cc] == 'v')
                curArea.wolf++;
            else if(board[cr][cc] == 'o')
                curArea.sheep++;

            for(int d = 0; d<4; d++){
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if(!check(nr, nc)) continue;
                if(visited[nr][nc]) continue;
                if(board[nr][nc] == '#') continue;

                visited[nr][nc] = true;
                que.offer(new Coordinate(nr, nc));
            }
        }

        if(curArea.sheep > curArea.wolf)
            curArea.wolf = 0;
        else
            curArea.sheep = 0;

        surviveSheep += curArea.sheep;
        surviveWolf += curArea.wolf;
    }
}