import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] LAN = new int[K];
        int max = 0;

        for (int i = 0; i < K; i++) {
            LAN[i] = Integer.parseInt(br.readLine());
            if (LAN[i] > max) max = LAN[i];
        }

        long lo = 1;
        long hi = max;
        long ans = 0;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            long cnt = 0;

            for (int len : LAN) {
                cnt += (len / mid);
            }

            if (cnt >= N) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(ans);
    }
}