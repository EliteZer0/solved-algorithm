import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static final int INF = 987654321;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] relation = new int[N+1][N+1];

        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                if(i == j) relation[i][j] = 0;
                relation[i][j] = INF;
            }
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            relation[A][B] = 1;
            relation[B][A] = 1;
        }

        for(int k = 1; k<=N; k++){
            for(int i = 1; i<=N; i++){
                for(int j = 1; j<=N; j++){
                    if((relation[i][k] + relation[k][j])
                       < relation[i][j]) relation[i][j] = relation[i][k] + relation[k][j];
                }
            }
        }

        int idx = 0;
        int min = INF;
        int sum = 0;
        for(int i = N; i>0; i--){
            sum = 0;
            for(int j = N; j>0; j--){
                if(i == j) continue;
                sum += relation[i][j];
            }
            if(min>=sum){
                idx = i;
                min = sum;
            }
        }
        
        System.out.println(idx);
    }
}