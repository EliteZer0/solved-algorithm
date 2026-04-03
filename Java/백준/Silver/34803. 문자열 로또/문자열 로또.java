import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int L = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            strings[i] = br.readLine();
        }
        
        int K = Integer.parseInt(br.readLine());
        
        // 모든 가능한 길이 K인 부분 문자열을 저장
        HashMap<String, Integer> scoreMap = new HashMap<>();
        
        // 각 문자열에서 길이 K인 모든 부분 문자열을 추출하고 점수 계산
        for (int i = 0; i < N; i++) {
            String str = strings[i];
            // 각 부분 문자열의 등장 횟수를 세기
            for (int j = 0; j <= L - K; j++) {
                String substring = str.substring(j, j + K);
                scoreMap.put(substring, scoreMap.getOrDefault(substring, 0) + 1);
            }
        }
        
        // 최대 점수 찾기
        int maxScore = 0;
        for (int score : scoreMap.values()) {
            maxScore = Math.max(maxScore, score);
        }
        
        System.out.println(maxScore);
    }
}