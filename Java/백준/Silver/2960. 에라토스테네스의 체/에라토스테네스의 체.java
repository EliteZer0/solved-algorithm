import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] removed = new boolean[N + 1];
        int cnt = 0;

        for (int p = 2; p <= N; p++) {
            if (removed[p]) continue;

            for (int m = p; m <= N; m += p) {
                if (removed[m]) continue;
                removed[m] = true;
                cnt++;
                if (cnt == K) {
                    System.out.println(m);
                    return;
                }
            }
        }
    }
}
