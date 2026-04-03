import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        int count = 0;
        int num = 666;
        
        while (true) {
            // 현재 숫자에 "666"이 포함되어 있는지 확인
            if (String.valueOf(num).contains("666")) {
                count++;
                
                // N번째 종말의 수를 찾았으면 출력
                if (count == N) {
                    sb.append(num);
                    break;
                }
            }
            num++;
        }
        
        System.out.println(sb.toString());
    }
}