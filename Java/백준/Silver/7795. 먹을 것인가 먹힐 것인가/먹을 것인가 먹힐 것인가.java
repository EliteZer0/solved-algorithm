import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc<T; tc++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                A[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++)
                B[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(A);
            Arrays.sort(B);

            int left = 0;
            int right = 0;
            int cnt = 0;

            while (right < N) {
                while (left < M && B[left] < A[right]) {
                    left++;
                }
                cnt += left;
                right++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
}