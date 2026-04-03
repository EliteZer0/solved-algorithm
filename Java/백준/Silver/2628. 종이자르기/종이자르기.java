import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine().trim());

        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();

        xs.add(0); xs.add(W);
        ys.add(0); ys.add(H);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            if (dir == 1) xs.add(pos);
            else ys.add(pos);
        }

        Collections.sort(xs);
        Collections.sort(ys);

        int maxW = 0;
        for (int i = 1; i < xs.size(); i++) {
            maxW = Math.max(maxW, xs.get(i) - xs.get(i - 1));
        }

        int maxH = 0;
        for (int i = 1; i < ys.size(); i++) {
            maxH = Math.max(maxH, ys.get(i) - ys.get(i - 1));
        }

        System.out.println(maxW * maxH);
    }
}
