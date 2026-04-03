import java.util.*;
import java.lang.*;
import java.io.*;
// A일 때 B한 C값을 찾아라
// A : 현재 정수 x
// B : 1*2 타일 하나만 붙이거나, 2*1 타일 두개 붙이기
// C : 2*x를 1×2, 2×1 타일로 채우는 방법의 수 % 10_007
// 상태 : dp[x] = 2*x를 1×2, 2×1 타일로 채우는 방법의 수 % 10_007
// 점화식 : dp[x] = dp[x-1] + dp[x-2]
// 점화식이 저렇게 나오는 이유
// x-1 채우는 가짓수에다 세로 타일 하나만 붙이면 됨
// x-2 채우는 가짓수에다 가로 타일 두개 붙이면 됨
// 결국 1 작은 피보나치임
class Main {
    static int MOD = 10_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] dp = new int[n+1];

        dp[1] = 1;
        if(n>=2) dp[2] = 2;
    
        for(int i = 3; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2])%MOD;
        }
       
        System.out.println(dp[n]);
    }
}