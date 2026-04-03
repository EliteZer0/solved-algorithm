import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int target = Integer.parseInt(br.readLine().trim());

        int[][] a = new int[N][N];

        int r = N / 2;
        int c = N / 2;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int val = 1;
        a[r][c] = val;

        int ansR = (val == target) ? r + 1 : -1;
        int ansC = (val == target) ? c + 1 : -1;

        int dir = 0;
        int len = 1;

        while (val < N * N) {
            for (int rep = 0; rep < 2; rep++) {
                for (int i = 0; i < len; i++) {
                    r += dr[dir];
                    c += dc[dir];
                    a[r][c] = ++val;

                    if (val == target) {
                        ansR = r + 1;
                        ansC = c + 1;
                    }
                    if (val == N * N) break;
                }
                dir = (dir + 1) % 4;
                if (val == N * N) break;
            }
            len++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(a[i][j]);
                if (j + 1 < N) sb.append(' ');
            }
            sb.append('\n');
        }
        sb.append(ansR).append(' ').append(ansC).append('\n');

        System.out.print(sb.toString());
    }
}
