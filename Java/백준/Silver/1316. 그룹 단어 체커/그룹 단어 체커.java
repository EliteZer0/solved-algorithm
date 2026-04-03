import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            if (check(br)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean check(BufferedReader br) throws IOException {
        boolean[] check = new boolean[26];
        int prev = 0;
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i);

            if (prev != now) {
                if (!check[now - 'a']) {
                    check[now - 'a'] = true;
                    prev = now;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}