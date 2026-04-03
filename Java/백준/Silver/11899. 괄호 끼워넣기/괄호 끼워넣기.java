import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        int balance = 0;
        int needOpen = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') balance++;
            else balance--;

            if (balance < 0) {
                needOpen++;
                balance++;
            }
        }

        int answer = needOpen + balance;
        System.out.println(answer);
    }
}
