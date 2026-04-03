import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int mask = 0;
        int ALL = (1 << 20) - 1;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "add": {
                    int x = Integer.parseInt(st.nextToken());
                    mask |= (1 << (x - 1));
                    break;
                }
                case "remove": {
                    int x = Integer.parseInt(st.nextToken());
                    mask &= ~(1 << (x - 1));
                    break;
                }
                case "check": {
                    int x = Integer.parseInt(st.nextToken());
                    sb.append((mask & (1 << (x - 1))) != 0 ? 1 : 0).append('\n');
                    break;
                }
                case "toggle": {
                    int x = Integer.parseInt(st.nextToken());
                    mask ^= (1 << (x - 1));
                    break;
                }
                case "all":
                    mask = ALL;
                    break;
                case "empty":
                    mask = 0;
                    break;
            }
        }

        System.out.print(sb);
    }
}