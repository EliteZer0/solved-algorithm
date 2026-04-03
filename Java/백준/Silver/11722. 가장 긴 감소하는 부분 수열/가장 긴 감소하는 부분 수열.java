import java.util.*;
import java.io.*;

/*
A : 현재 인덱스 i
B : i번째 원소를 마지막 원소로 선택하면서,
이전에 올 수 있는 원소 j 중에서 감소하는 부분 수열을 유지
C : i번째 원소를 마지막으로 하는 가장 긴 감소 부분 수열의 길이
상태 정의: dp[i] = i번째 원소를 마지막으로 하는 가장 긴 감소 부분 수열의 길이
점화식: dp[i] = max(dp[j] + 1) (단, j < i 이고 num[i] < num[j])
*/

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		int[] dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if(num[i]<num[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
    }
}