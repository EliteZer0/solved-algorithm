import java.io.*;
import java.util.*;

public class Main {
    static class Meeting {
        long s, e;
        Meeting(long s, long e) { this.s = s; this.e = e; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        Meeting[] arr = new Meeting[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long s = Long.parseLong(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            arr[i] = new Meeting(s, e);
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.e == b.e) return Long.compare(a.s, b.s);
            return Long.compare(a.e, b.e);
        });

        long end = 0;
        int count = 0;

        for (Meeting m : arr) {
            if (m.s >= end) {
                count++;
                end = m.e;
            }
        }

        System.out.println(count);
    }
}
