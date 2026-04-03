import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int cmdCnt = 2 * k;

        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] cmd = new char[cmdCnt];
        for (int i = 0; i < cmdCnt; i++) cmd[i] = st.nextToken().charAt(0);

        int h = Integer.parseInt(br.readLine());

        // 1*1 배열에서 시작해서 종이를 펼칠때마다 배열 확장
        int[][] arr = new int[1][1];
        arr[0][0] = h;

        // 접은 순서 역순으로 펼치기
        for (int i = cmdCnt - 1; i >= 0; i--) {
            char c = cmd[i];
            arr = expand(arr, c);
        }
        
        StringBuilder sb = new StringBuilder();
        int N = arr.length;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (c > 0) sb.append(' ');
                sb.append(arr[r][c]);
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }

    static int[][] expand(int[][] arr, char fold) {
        int H = arr.length;
        int W = arr[0].length;

        if (fold == 'R' || fold == 'L') {
            int[][] next = new int[H][W * 2];

            if (fold == 'R') {
                // 기존 arr은 오른쪽
                for (int r = 0; r < H; r++) {
                    for (int c = 0; c < W; c++) {
                        next[r][c + W] = arr[r][c];
                    }
                }
                // 왼쪽 좌우반사
                for (int r = 0; r < H; r++) {
                    for (int c = 0; c < W; c++) {
                        next[r][c] = flipLR(arr[r][W - 1 - c]);
                    }
                }
            } else {
                // 기존 arr은 왼쪽
                for (int r = 0; r < H; r++) {
                    for (int c = 0; c < W; c++) {
                        next[r][c] = arr[r][c];
                    }
                }
                // 오른쪽 좌우반사
                for (int r = 0; r < H; r++) {
                    for (int c = 0; c < W; c++) {
                        next[r][c + W] = flipLR(arr[r][W - 1 - c]);
                    }
                }
            }
            return next;
        }

        if (fold == 'U' || fold == 'D') {
            int[][] next = new int[H * 2][W];

            if (fold == 'U') {
                // 기존 arr은 위쪽
                for (int r = 0; r < H; r++) {
                    for (int c = 0; c < W; c++) {
                        next[r][c] = arr[r][c];
                    }
                }
                // 아래쪽 상하반사
                for (int r = 0; r < H; r++) {
                    for (int c = 0; c < W; c++) {
                        next[r + H][c] = flipUD(arr[H - 1 - r][c]);
                    }
                }
            } else {
                // 기존 arr은 아래쪽
                for (int r = 0; r < H; r++) {
                    for (int c = 0; c < W; c++) {
                        next[r + H][c] = arr[r][c];
                    }
                }
                // 위쪽 상하반사
                for (int r = 0; r < H; r++) {
                    for (int c = 0; c < W; c++) {
                        next[r][c] = flipUD(arr[H - 1 - r][c]);
                    }
                }
            }
            return next;
        }

        return arr;
    }

    // 좌우 반사 0<->1, 2<->3
    static int flipLR(int cmd){
        switch (cmd) {
            case 0: return 1;
            case 1: return 0;
            case 2: return 3;
            case 3: return 2;
        }
        return -1;
    }

    // 상하 반사 0<->2, 1<->3
    static int flipUD(int cmd) { 
        switch (cmd) {
            case 0: return 2;
            case 2: return 0;
            case 1: return 3;
            case 3: return 1;
        }
        return -1;
    }
}