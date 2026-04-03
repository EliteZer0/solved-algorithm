import java.util.*;
import java.lang.*;
import java.io.*;
/*
Ai = A(i를 P로 나눈 몫) + A(i를 Q로 나눈 몫)
상태 : dp[n] = n번째 수열 값
점화식 : dp[n] = dp[n/p] + dp[n/q]
기저 조건 : dp[0] = 1

문제는 배열로 접근하기엔 범위가 너무 큼 -> 메모리 초과
N까지 다 계산하면 시간 초과도 날 것

방법?

이 수열은 n → n/P → n/P² 형태로 계속 나누어지기 때문에
실제로 계산되는 서로 다른 n의 개수는 매우 적음
필요한 값만 저장하면 되므로 배열 대신 HashMap 사용
*/
class Main {
    static long P, Q;
    static final Map<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        System.out.println(solve(N));
    }

    
    static long solve(long n) {
        if (n == 0) return 1L;

        Long cached = memo.get(n);
        if (cached != null) return cached;

        long val = solve(n / P) + solve(n / Q);
        memo.put(n, val);
        return val;
    }
}