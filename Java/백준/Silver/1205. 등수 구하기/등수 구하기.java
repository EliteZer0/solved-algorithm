import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 0) {
            System.out.println(1);
            return;
        }

        if (N == P && S <= arr[N - 1]) {
            System.out.println(-1);
            return;
        }

        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (arr[i] <= S) {
                rank = i + 1;
                System.out.println(rank);
                return;
            }
        }

        System.out.println(N + 1);
    }
}
