import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static final int INF = 987654321;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] map = new int[n+1][n+1];

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(i == j) map[i][j] = 0;
                else map[i][j] = INF;
            }
        }
        
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 이 조건 안 넣으면 틀림
            if(map[a][b]>c) map[a][b] = c;
        }

        for(int k = 1; k<=n; k++){
            for(int i = 1; i<=n; i++){
                for(int j = 1; j<=n; j++){
                    if(i==j) continue;
                    if((map[i][k] + map[k][j])
                       < map[i][j]) map[i][j] = map[i][k] + map[k][j];
                }
            }
        }

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                // INF 지워줘야함
                if(map[i][j] == INF) sb.append(0);
                else sb.append(map[i][j]);
                if(j<n) sb.append(" ");
            }
            if(i<n) sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}