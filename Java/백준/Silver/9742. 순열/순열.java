import java.io.*;
import java.util.*;

public class Main {
    static long[] fact = new long[11];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        fact[0] = 1;
        for (int i = 1; i <= 10; i++) {
            fact[i] = fact[i - 1] * i;
        }

        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            StringTokenizer st = new StringTokenizer(line);
            String s = st.nextToken();
            long k = Long.parseLong(st.nextToken());

            sb.append(s).append(" ").append(k).append(" = ");

            int n = s.length();
            long total = fact[n];

            if (k < 1 || k > total) {
                sb.append("No permutation\n");
                continue;
            }

            List<Character> chars = new ArrayList<>();
            for (char c : s.toCharArray()) {
                chars.add(c);
            }

            long idx = k - 1;

            StringBuilder ans = new StringBuilder();

            for (int i = n; i >= 1; i--) {
                long block = fact[i - 1];
                int pick = (int) (idx / block);
                ans.append(chars.get(pick));
                chars.remove(pick);
                idx %= block;
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}