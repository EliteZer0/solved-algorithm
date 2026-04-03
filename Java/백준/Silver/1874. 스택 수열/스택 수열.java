import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int next = 1;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine().trim());

            while (next <= n && (stack.isEmpty() || stack.peek() < x)) {
                stack.push(next++);
                sb.append("+\n");
            }

            if (!stack.isEmpty() && stack.peek() == x) {
                stack.pop();
                sb.append("-\n");
            } else {
                System.out.print("NO");
                return;
            }
        }

        System.out.print(sb.toString());
    }
}
