import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] A = new int[N];
        
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }
        
        int maxLength = 1;
        
        // 각 시작 위치에서 지그재그 수열의 최대 길이 찾기
        for (int start = 0; start < N; start++) {
            int length = 1;
            
            // 현재 시작점부터 최대한 길게 확장
            for (int end = start + 1; end < N; end++) {
                length++;
                
                // 길이가 3 이상일 때 지그재그 조건 체크
                if (length >= 3) {
                    int i = end - 2;
                    // 단조증가 또는 단조감소인지 체크
                    if ((A[i] <= A[i+1] && A[i+1] <= A[i+2]) || 
                        (A[i] >= A[i+1] && A[i+1] >= A[i+2])) {
                        // 지그재그가 아니므로 여기서 중단
                        length--;
                        break;
                    }
                }
            }
            
            maxLength = Math.max(maxLength, length);
        }
        System.out.println(maxLength);
    }
}