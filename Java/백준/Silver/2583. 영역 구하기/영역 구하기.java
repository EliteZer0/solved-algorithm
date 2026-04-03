import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int M, N, K;
    static boolean[][] blocked;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        blocked = new boolean[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    blocked[y][x] = true;
                }
            }
        }

        ArrayList<Integer> areas = new ArrayList<>();
        int count = 0;

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (!blocked[r][c] && !visited[r][c]) {
                    count++;
                    areas.add(bfs(r, c));
                }
            }
        }

        Collections.sort(areas);

        StringBuilder sb = new StringBuilder();
        sb.append(count).append('\n');
        for (int i = 0; i < areas.size(); i++) {
            if (i > 0) sb.append(' ');
            sb.append(areas.get(i));
        }
        System.out.println(sb);
    }

    static int bfs(int sr, int sc) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[sr][sc] = true;
        q.add(new int[]{sr, sc});
        int area = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
                if (blocked[nr][nc] || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
                area++;
            }
        }
        return area;
    }
}