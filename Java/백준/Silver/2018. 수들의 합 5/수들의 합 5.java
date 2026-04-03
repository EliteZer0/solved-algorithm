import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int left = 1;
        int right = 1;
        int sum = 1;
        int cnt = 0;

        while (left <= N) {
            if (sum == N) {
                cnt++;
                sum -= left;
                left++;
            } else if (sum < N) {
                right++;
                if (right > N) break;
                sum += right;
            } else {
                sum -= left;
                left++;
            }
        }
        
        System.out.println(cnt);
    }
}