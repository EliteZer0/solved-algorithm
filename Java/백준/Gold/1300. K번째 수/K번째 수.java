import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static long k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        k = Long.parseLong(br.readLine());

        long left = 1;
        long right = k;
        long ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (check(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }

    static boolean check(long x) {
        long cnt = 0;

        for (int i = 1; i <= N; i++) {
            cnt += Math.min((long) N, x / i);
        }

        return cnt >= k;
    }
}