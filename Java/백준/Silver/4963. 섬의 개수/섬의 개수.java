import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static int[][] map;
    static boolean[][] visited;

    // 8방향
    static int[] dr = {-1,-1,-1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1,-1, 1,-1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int r = 0; r < h; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < w; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            int islands = 0;
            for (int r = 0; r < h; r++) {
                for (int c = 0; c < w; c++) {
                    if (map[r][c] == 1 && !visited[r][c]) {
                        bfs(r, c);
                        islands++;
                    }
                }
            }

            out.append(islands).append('\n');
        }

        System.out.print(out.toString());
    }

    static void bfs(int sr, int sc) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[sr][sc] = true;
        q.add(new int[]{sr, sc});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int d = 0; d < 8; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] == 0) continue;

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
    }
}