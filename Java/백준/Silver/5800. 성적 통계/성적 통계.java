import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int K = Integer.parseInt(br.readLine());
        
        for (int classNum = 1; classNum <= K; classNum++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);

            int[] scores = new int[N];
            for (int i = 0; i < N; i++) {
                scores[i] = Integer.parseInt(input[i + 1]);
            }
            
            Arrays.sort(scores);
            
            int largestGap = 0;
            for (int i = 0; i < N - 1; i++) {
                int gap = scores[i+1] - scores[i];
                if (gap > largestGap) largestGap = gap;
            }
            
            int max = scores[N-1];
            int min = scores[0];

            sb.append("Class ").append(classNum).append("\n");
            sb.append("Max ").append(max).append(", Min ").append(min)
              .append(", Largest gap ").append(largestGap).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}