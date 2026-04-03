import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        // 0과 1의 그룹 수를 센다
        int cnt0 = 0;  // 0의 그룹 수
        int cnt1 = 0;  // 1의 그룹 수
        
        // 첫 번째 문자에 따라 초기 그룹 카운트
        if(input.charAt(0) == '0') {
            cnt0 = 1;
        } else {
            cnt1 = 1;
        }
        
        // 문자가 바뀔 때마다 새로운 그룹이 시작됨
        for(int i = 1; i < input.length(); i++) {
            if(input.charAt(i) != input.charAt(i-1)) {
                if(input.charAt(i) == '0') {
                    cnt0++;
                } else {
                    cnt1++;
                }
            }
        }
        
        // 더 작은 그룹 수만큼 뒤집으면 됨
        int ans = Math.min(cnt0, cnt1);
        System.out.println(ans);
    }
}