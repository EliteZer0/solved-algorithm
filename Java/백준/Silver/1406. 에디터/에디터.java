import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String initial = br.readLine();
        int m = Integer.parseInt(br.readLine());
        
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        
        for (int i = 0; i < initial.length(); i++) {
            left.push(initial.charAt(i));
        }
        
        for (int i = 0; i < m; i++) {
            String command = br.readLine();
            char cmd = command.charAt(0);
            
            if (cmd == 'L') {
                if (!left.isEmpty()) {
                    right.push(left.pop());
                }
            } else if (cmd == 'D') {
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }
            } else if (cmd == 'B') {
                if (!left.isEmpty()) {
                    left.pop();
                }
            } else if (cmd == 'P') {
                char ch = command.charAt(2);
                left.push(ch);
            }
        }
        
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        
        System.out.println(sb.toString());
    }
}