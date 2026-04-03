import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int low = 1;
        int high = houses[N-1] - houses[0];
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            int position = 0;
            int cnt = 1;

            for(int i = 1; i < N; i++) {
                if (houses[i] - houses[position] >= mid) {
                    position = i;
                    cnt++;
                }
            }

            if(cnt < C){
                high = mid - 1;
                continue;
            } else{
                result = mid;
                low = mid + 1;
            }


        }
        
        System.out.println(result);
    }
}