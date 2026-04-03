import java.io.*;
import java.util.*;

public class Main {
    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;

    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            int count = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (map[y][x] == 1 && !visited[y][x]) {
                        bfs(y, x);
                        count++;
                    }
                }
            }

            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }

    static void bfs(int sy, int sx) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[sy][sx] = true;
        q.add(new int[]{sy, sx});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] == 0) continue;

                visited[ny][nx] = true;
                q.add(new int[]{ny, nx});
            }
        }
    }
}
