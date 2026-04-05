import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] serverRoom;
    static long totalComCnt;
    static int n;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        serverRoom = new int[n][n];

        // 한칸에 최대 10_000_000개
        // 칸은 최대 1_000_000개
        // 워스트 10_000_000_000_000개 int로 처리 불가
        totalComCnt = 0;
        // 서버실 아래부터 차오른다고 해서 역순으로 받기
        // 문제 이해를 잘못한 휴먼 에러... 근데 고치기 귀찮았다.
        for(int r = n-1; r >= 0; r--){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < n; c++){
                serverRoom[r][c] = Integer.parseInt(st.nextToken());
                totalComCnt += serverRoom[r][c];
            }
        }

        int left = 0;
        int right = 100000000;
        int ans = 0;

        while(left <= right) {
            int mid = (left + right) / 2;

            if (isHalf(mid)){
                ans = mid;
                right = mid -1;
            }
            else{
                left = mid +1;
            }
        }

        System.out.print(ans);
    }

    // 문제 이해를 잘못 함
    // 컴퓨터 1칸 높이이기 때문에 모든 맵을 다 돌아야함
    // 행과는 상관이 없음
    static boolean isHalf(int x){
        long comCnt = 0;
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                if(serverRoom[r][c] >= x)
                    comCnt += x;
                else
                    comCnt += serverRoom[r][c];
            }
        }

        if(comCnt * 2 >= totalComCnt)
            return true;
        return false;
    }
}