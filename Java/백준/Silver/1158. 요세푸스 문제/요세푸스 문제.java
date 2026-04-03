import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) list.add(i);

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int idx = 0;
        for (int removed = 0; removed < N; removed++) {
            idx = (idx + (K - 1)) % list.size();
            int val = list.remove(idx);

            sb.append(val);
            if (removed != N - 1) sb.append(", ");
        }

        sb.append(">");
        System.out.println(sb.toString());
    }
}
