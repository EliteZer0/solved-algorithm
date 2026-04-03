import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static long X, Y, Z;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        Z = (Y * 100) / X;

        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        long left = 1;
        long right = 1_000_000_000L;
        long ans = -1;

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

    static boolean check(long k) {
        long newZ = ((Y + k) * 100) / (X + k);
        return newZ > Z;
    }
}