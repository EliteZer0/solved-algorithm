import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, Q;
    static int[][] school;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        school = new int[6][N+2];

        for(int i = 0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if(cmd == 1){
                int floor = Integer.parseInt(st.nextToken());
                int classNum = Integer.parseInt(st.nextToken());

                construction(floor, classNum);
            } else{
                int floor = Integer.parseInt(st.nextToken());

                sb.append(print(floor)).append("\n");
            }
        }

        int floor = 4;
        int classNum = N;
        int max = 0;
        for(int i = 4; i>0; i--){
            for(int j = N; j>0; j--){
                if(max<=school[i][j]){
                    max = school[i][j];
                    floor = i;
                    classNum = j;
                }
            }
        }

        sb.append(floor).append(" ").append(classNum);
        
        System.out.println(sb.toString());
    }
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static void construction(int floor, int classNum){
        school[floor][classNum] ++;
        for(int d = 0; d<4; d++){
            int mr = floor + dr[d];
            int mc = classNum + dc[d];
            school[mr][mc] ++;
        }
    }
    
    static int print(int floor){
        int max = 0;
        int classNum = N;
        for(int c = N; c>0; c--){
            if(max<= school[floor][c]){
                max = school[floor][c];
                classNum = c;
            }
        }

        return classNum;
    }
}