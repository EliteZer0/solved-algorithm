import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        Set<String> seen = new HashSet<>();
        int ans = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine().trim();

            if (s.equals("ENTER")) {
                seen.clear();
            } else {
                if (seen.add(s)) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
