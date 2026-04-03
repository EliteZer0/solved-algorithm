import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[] zero = new int[41];
        int[] one = new int[41];

        zero[0] = 1; one[0] = 0;
        zero[1] = 0; one[1] = 1;

        for (int i = 2; i <= 40; i++) {
            zero[i] = zero[i - 1] + zero[i - 2];
            one[i]  = one[i - 1]  + one[i - 2];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(zero[N]).append(" ").append(one[N]).append("\n");
        }

        System.out.print(sb);
    }
}
