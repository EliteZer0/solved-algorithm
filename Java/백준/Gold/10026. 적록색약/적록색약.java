import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        
        // 그리드 입력
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        
        // 적록색약이 아닌 사람의 구역 수
        int normalCount = countRegions(false);
        
        // 적록색약인 사람의 구역 수
        int colorblindCount = countRegions(true);
        
        System.out.println(normalCount + " " + colorblindCount);
    }
    
    static int countRegions(boolean isColorblind) {
        visited = new boolean[N][N];
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, isColorblind);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    static void bfs(int startX, int startY, boolean isColorblind) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        char startColor = grid[startX][startY];
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    char currentColor = grid[nx][ny];
                    
                    if (isSameColor(startColor, currentColor, isColorblind)) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
    
    static boolean isSameColor(char color1, char color2, boolean isColorblind) {
        if (color1 == color2) {
            return true;
        }
        
        // 적록색약인 경우 R과 G를 같은 색으로 본다
        if (isColorblind) {
            if ((color1 == 'R' && color2 == 'G') || (color1 == 'G' && color2 == 'R')) {
                return true;
            }
        }
        
        return false;
    }
}