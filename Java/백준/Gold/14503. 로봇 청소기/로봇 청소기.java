import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] room;
    static boolean[][] cleaned;
    static int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dc = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        room = new int[N][M];
        cleaned = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int result = simulate(r, c, d);
        System.out.println(result);
    }
    
    static int simulate(int r, int c, int d) {
        int cleanedCount = 0;
        
        while (true) {
            // 1. 현재 칸이 청소되지 않은 경우 청소
            if (!cleaned[r][c]) {
                cleaned[r][c] = true;
                cleanedCount++;
            }
            
            // 2. 주변 4칸 중 청소되지 않은 빈 칸이 있는지 확인
            boolean hasUncleanedCell = false;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && 
                    room[nr][nc] == 0 && !cleaned[nr][nc]) {
                    hasUncleanedCell = true;
                    break;
                }
            }
            
            if (!hasUncleanedCell) {
                // 2-1. 청소되지 않은 빈 칸이 없는 경우 후진 시도
                int backDir = (d + 2) % 4; // 뒤쪽 방향
                int backR = r + dr[backDir];
                int backC = c + dc[backDir];
                
                if (backR >= 0 && backR < N && backC >= 0 && backC < M && 
                    room[backR][backC] == 0) {
                    // 후진 가능
                    r = backR;
                    c = backC;
                } else {
                    // 후진 불가능 - 작동 멈춤
                    break;
                }
            } else {
                // 3. 청소되지 않은 빈 칸이 있는 경우
                while (true) {
                    // 3-1. 반시계 방향으로 90도 회전
                    d = (d + 3) % 4; // 반시계 회전 (북->서->남->동->북)
                    
                    // 3-2. 앞쪽 칸이 청소되지 않은 빈 칸인지 확인
                    int frontR = r + dr[d];
                    int frontC = c + dc[d];
                    
                    if (frontR >= 0 && frontR < N && frontC >= 0 && frontC < M &&
                        room[frontR][frontC] == 0 && !cleaned[frontR][frontC]) {
                        // 전진
                        r = frontR;
                        c = frontC;
                        break;
                    }
                }
            }
        }
        
        return cleanedCount;
    }
}