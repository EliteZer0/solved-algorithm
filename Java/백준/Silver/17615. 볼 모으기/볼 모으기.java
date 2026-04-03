import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        String balls = br.readLine();
        
        // 한 가지 색만 있는 경우
        if (balls.chars().allMatch(c -> c == 'R') || balls.chars().allMatch(c -> c == 'B')) {
            sb.append(0);
            System.out.println(sb.toString());
            return;
        }
        
        int answer = N; // 최댓값으로 초기화
        
        // 1. 빨간 볼을 왼쪽으로 모으기
        answer = Math.min(answer, moveToLeft(balls, 'R'));
        
        // 2. 빨간 볼을 오른쪽으로 모으기
        answer = Math.min(answer, moveToRight(balls, 'R'));
        
        // 3. 파란 볼을 왼쪽으로 모으기
        answer = Math.min(answer, moveToLeft(balls, 'B'));
        
        // 4. 파란 볼을 오른쪽으로 모으기
        answer = Math.min(answer, moveToRight(balls, 'B'));
        
        sb.append(answer);
        System.out.println(sb.toString());
    }
    
    // 특정 색을 왼쪽으로 모으는 경우
    static int moveToLeft(String balls, char color) {
        int count = 0;
        boolean startCounting = false;
        
        for (int i = 0; i < balls.length(); i++) {
            if (balls.charAt(i) == color) {
                if (startCounting) {
                    count++;
                }
            } else {
                startCounting = true;
            }
        }
        
        return count;
    }
    
    // 특정 색을 오른쪽으로 모으는 경우
    static int moveToRight(String balls, char color) {
        int count = 0;
        boolean startCounting = false;
        
        for (int i = balls.length() - 1; i >= 0; i--) {
            if (balls.charAt(i) == color) {
                if (startCounting) {
                    count++;
                }
            } else {
                startCounting = true;
            }
        }
        
        return count;
    }
}