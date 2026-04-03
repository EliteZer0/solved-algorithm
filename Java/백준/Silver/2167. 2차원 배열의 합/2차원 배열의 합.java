import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N+1][M+1];
        int[][] prefix = new int[N+1][M+1];
        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + board[i][j];
            }
        }

        int K = Integer.parseInt(br.readLine());
        for(int tc = 0; tc<K; tc++){
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            
            int sum = prefix[r2][c2] - prefix[r1-1][c2] - prefix[r2][c1-1] + prefix[r1-1][c1-1];
            sb.append(sum).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}