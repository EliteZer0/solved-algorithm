import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int cnt = 0;

        while (B > A) {
            if (B % 2 == 0) {
                B /= 2;
                cnt++;
            } else if (B % 10 == 1) {
                B = (B - 1) / 10;
                cnt++;
            } else {
                System.out.println(-1);
                return;
            }
        }

        if (B == A) System.out.println(cnt + 1);
        else System.out.println(-1);
    }
}