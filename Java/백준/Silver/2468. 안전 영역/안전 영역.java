import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int maxSafeZone = 0;

        // 비가 h만큼 왔다고 가정 (0부터 maxHeight까지 시뮬레이션)
        for (int h = 0; h <= maxHeight; h++) {
            visited = new boolean[N][N];
            int count = 0;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (!visited[r][c] && map[r][c] > h) {
                        dfs(r, c, h);
                        count++;
                    }
                }
            }

            maxSafeZone = Math.max(maxSafeZone, count);
        }

        System.out.println(maxSafeZone);
    }

    static void dfs(int r, int c, int height) {
        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                if (!visited[nr][nc] && map[nr][nc] > height) {
                    dfs(nr, nc, height);
                }
            }
        }
    }
}