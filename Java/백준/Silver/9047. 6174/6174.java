import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            int count = kaprekar(num);
            sb.append(count).append('\n');
        }
        
        System.out.print(sb);
    }
    
    private static int kaprekar(int num) {
        int count = 0;
        
        while (num != 6174) {
            // 네 자리 숫자를 배열로 변환
            int[] digits = new int[4];
            digits[0] = num / 1000;
            digits[1] = (num / 100) % 10;
            digits[2] = (num / 10) % 10;
            digits[3] = num % 10;
            
            // 정렬
            Arrays.sort(digits);
            
            // 가장 작은 수 (오름차순)
            int small = digits[0] * 1000 + digits[1] * 100 + digits[2] * 10 + digits[3];
            
            // 가장 큰 수 (내림차순)
            int large = digits[3] * 1000 + digits[2] * 100 + digits[1] * 10 + digits[0];
            
            // 차이 계산
            num = large - small;
            count++;
        }
        
        return count;
    }
}