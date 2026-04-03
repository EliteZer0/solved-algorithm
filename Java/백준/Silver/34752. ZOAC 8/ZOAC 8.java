import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[100000];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i < 100000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 100000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // 누적 소수 개수 배열 생성
        int[] primeCount = new int[100000];
        for (int i = 1; i < 100000; i++) {
            primeCount[i] = primeCount[i-1] + (isPrime[i] ? 1 : 0);
        }
        
        int maxScore = -1;
        int minScore = Integer.MAX_VALUE;
        String luckyWinner = "";
        String unluckyWinner = "";
        
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            String number = input[1];
            
            int x = Integer.parseInt(number.substring(0, 5));
            int y = Integer.parseInt(number.substring(5, 10));
            
            int min = Math.min(x, y);
            int max = Math.max(x, y);
            
            // min부터 max까지의 소수 개수
            int score = primeCount[max] - primeCount[min-1];
            
            // 행운상 (최고 점수)
            if (score > maxScore || (score == maxScore && name.compareTo(luckyWinner) < 0)) {
                maxScore = score;
                luckyWinner = name;
            }
            
            // 불운상 (최저 점수)
            if (score < minScore || (score == minScore && name.compareTo(unluckyWinner) < 0)) {
                minScore = score;
                unluckyWinner = name;
            }
        }
        
        sb.append(luckyWinner).append("\n");
        sb.append(unluckyWinner).append("\n");
        
        System.out.print(sb.toString());
    }
}
