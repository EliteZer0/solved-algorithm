import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static char[][] map;
    static boolean[][] visited;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        ArrayList<Integer> sizes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == '1') {
                    int size = dfsCount(i, j);
                    sizes.add(size);
                }
            }
        }

        Collections.sort(sizes);

        StringBuilder sb = new StringBuilder();
        sb.append(sizes.size()).append('\n');
        for (int s : sizes) sb.append(s).append('\n');

        System.out.print(sb.toString());
    }

    static int dfsCount(int r, int c) {
        visited[r][c] = true;
        int cnt = 1;

        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            if (visited[nr][nc]) continue;
            if (map[nr][nc] == '0') continue;

            cnt += dfsCount(nr, nc);
        }

        return cnt;
    }
}