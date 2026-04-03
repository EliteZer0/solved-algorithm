import java.io.*;
import java.util.*;

public class Main {
    public static boolean canFitInMBlurays(int[] lectures, int m, int bluraySize) {
        int currentBluraySize = 0;
        int bluraysUsed = 1;
        
        for (int lectureLength : lectures) {
            // 현재 블루레이에 강의를 추가할 수 있는지 확인
            if (currentBluraySize + lectureLength <= bluraySize) {
                currentBluraySize += lectureLength;
            } else {
                // 새로운 블루레이가 필요
                bluraysUsed++;
                currentBluraySize = lectureLength;
                
                // M개를 초과하면 불가능
                if (bluraysUsed > m) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static int findMinimumBluraySize(int n, int m, int[] lectures) {
        // 탐색 범위 설정
        // 최소값: 가장 긴 강의의 길이 (하나의 강의도 담을 수 없으면 안됨)
        int left = 0;
        int right = 0;
        
        for (int lecture : lectures) {
            left = Math.max(left, lecture);
            right += lecture;
        }
        
        int result = right;
        
        // 이분탐색 수행
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // 현재 크기로 M개의 블루레이에 담을 수 있는지 확인
            if (canFitInMBlurays(lectures, m, mid)) {
                result = mid;  // 가능하므로 결과 업데이트
                right = mid - 1;  // 더 작은 크기로 시도
            } else {
                left = mid + 1;  // 더 큰 크기가 필요
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] lectures = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
        }
        
        int result = findMinimumBluraySize(n, m, lectures);
        
        sb.append(result);
        System.out.println(sb.toString());
    }
}