import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] studentClass = new int[N][5];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                studentClass[i][j] = Integer.parseInt(line[j]);
            }
        }

        int[] studentCnt = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                for (int k = 0; k < 5; k++) {
                    if (studentClass[i][k] == studentClass[j][k]) {
                        studentCnt[i]++;
                        break;
                    }
                }
            }
        }

        int ans = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (studentCnt[i] > max) {
                max = studentCnt[i];
                ans = i;
            }
        }

        System.out.println(ans + 1);
    }
}
