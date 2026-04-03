import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushis = new int[N];

        for (int i = 0; i < N; i++) {
            sushis[i] = Integer.parseInt(br.readLine());
        }

        // 접시 개수 d + 쿠폰 1개
        int[] sushiCnt = new int[d+1];
        // 현재 먹을 수 있는 초밥 종류의 개수
        int curTypes = 0;
        for (int i = 0; i < k; i++) {
            if (sushiCnt[sushis[i]] == 0) {
                curTypes++;
            }
            sushiCnt[sushis[i]]++;
        }

        int maxTypes = curTypes;
        if (sushiCnt[c] == 0) {
            maxTypes = curTypes + 1;
        }

        for (int i = 1; i < N; i++) {
            sushiCnt[sushis[i-1]]--;
            if (sushiCnt[sushis[i-1]] == 0) {
                curTypes--;
            }

            int newSushi = sushis[(i+k-1) % N];
            if (sushiCnt[newSushi] == 0) {
                curTypes++;
            }
            sushiCnt[newSushi]++;

            int totalTypes = curTypes;
            if (sushiCnt[c] == 0) {
                totalTypes++;
            }

            maxTypes = Math.max(maxTypes, totalTypes);
        }

        System.out.println(maxTypes);
    }
}