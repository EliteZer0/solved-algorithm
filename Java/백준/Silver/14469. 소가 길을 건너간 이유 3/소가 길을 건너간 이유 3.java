import java.io.*;
import java.util.*;

public class Main {
    static class Cow {
        long arrive, check;
        Cow(long a, long c) { arrive = a; check = c; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        Cow[] cows = new Cow[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            cows[i] = new Cow(a, c);
        }

        Arrays.sort(cows, (x, y) -> Long.compare(x.arrive, y.arrive));

        long t = 0;
        for (Cow cow : cows) {
            if (t < cow.arrive) t = cow.arrive;
            t += cow.check;
        }

        System.out.println(t);
    }
}
