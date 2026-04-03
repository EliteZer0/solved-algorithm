import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static char[][] map;
    static int sr, sc;

    static class Signal {
        boolean infinite; // Voyager 판단
        long time;
        Signal(boolean infinite, long time) {
            this.infinite = infinite;
            this.time = time;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i = 0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }

        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken()) - 1;
        sc = Integer.parseInt(st.nextToken()) - 1;

        int bestDir = 0; // U부터 시작
        boolean bestInf = false;
        long bestTime = -1;

        for (int d = 0; d < 4; d++) {
            Signal sig = simulate(d);

            if (sig.infinite) {
                // 무한이 하나라도 있으면, U-R-D-L 우선순위로 가장 먼저 나온 방향이 정답
                bestDir = d;
                bestInf = true;
                break;
            } else {
                if (!bestInf && sig.time > bestTime) {
                    bestTime = sig.time;
                    bestDir = d;
                }
                // 동점이면 기존 bestDir이 더 앞선 방향이므로 갱신 안 함
            }
        }
        sb.append(command[bestDir]).append("\n");
        if (bestInf) sb. append("Voyager");
        else sb. append(bestTime);

        System.out.println(sb.toString());
    }
    
    static char[] command = {'U', 'R', 'D', 'L'};
    // '/' {'R', 'U', 'L', 'D'}
    static int[] slashCommandIDX = {1, 0, 3, 2};
    // '\' {'L', 'D', 'R', 'U'};
    static int[] backslashCommandIDX = {3, 2, 1, 0};
    
    static int[] dr = {-1, 0 , 1, 0};
    static int[] dc = {0, 1 , 0, -1};
    
    private static Signal simulate(int startDir) {
        boolean[][][] visited = new boolean[N][M][4];

        int r = sr;
        int c = sc;
        int dir = startDir;
        long time = 0;

        while (true) {
            // 같은 상태를 다시 방문하면 무한 루프
            if (visited[r][c][dir]) return new Signal(true, 0);
            visited[r][c][dir] = true;

            // 1초에 한 칸 이동
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            time++;

            // 밖으로 나가면 종료
            if (!check(nr, nc)) {
                return new Signal(false, time);
            }

            char cell = map[nr][nc];

            // 블랙홀 만나면 종료
            if (cell == 'C') {
                return new Signal(false, time);
            }

            // 행성이면 방향 전환
            if (cell == '/') {
                dir = slashCommandIDX[dir];
            } else if (cell == '\\') {
                dir = backslashCommandIDX[dir];
            }

            r = nr;
            c = nc;
        }
    }

    private static boolean check(int r, int c){
        return r<N && r>=0 && c<M && c>=0;
    }
}