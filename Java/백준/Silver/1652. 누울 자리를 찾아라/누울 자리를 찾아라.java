import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().trim().toCharArray();
        }

        int horiz = 0, vert = 0;

        for (int r = 0; r < N; r++) {
            int run = 0;
            for (int c = 0; c < N; c++) {
                if (map[r][c] == '.') run++;
                if (map[r][c] == 'X') {
                    if (run >= 2) horiz++;
                    run = 0;
                }
            }
            if (run >= 2) horiz++;
        }

        for (int c = 0; c < N; c++) {
            int run = 0;
            for (int r = 0; r < N; r++) {
                if (map[r][c] == '.') run++;
                if (map[r][c] == 'X') {
                    if (run >= 2) vert++;
                    run = 0;
                }
            }
            if (run >= 2) vert++;
        }

        System.out.println(horiz + " " + vert);
    }
}
