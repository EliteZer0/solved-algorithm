import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        long[] distances = new long[N];
        long[] prefixSum = new long[N];
        
        for(int i = 0; i < N; i++) {
            distances[i] = Long.parseLong(br.readLine());
            if(i == 0) {
                prefixSum[i] = distances[i];
            } else {
                prefixSum[i] = prefixSum[i-1] + distances[i];
            }
        }
        
        long total = prefixSum[N-1];
        int start = 0, end = 1;
        long minDiff = Long.MAX_VALUE;
        long result = 0;
        
        // 모든 가능한 구간 탐색
        while(start < N-1) {
            long route = prefixSum[end] - prefixSum[start];
            long otherRoute = total - route;
            long diff = Math.abs(route - otherRoute);
            
            // 두 경로의 차이가 최소일 때가 최대 거리
            if(diff < minDiff) {
                minDiff = diff;
                result = Math.min(route, otherRoute);
            }
            
            end++;
            if(end == N) {
                start++;
                end = start + 1;
            }
        }
        
        System.out.println(result);
    }
}