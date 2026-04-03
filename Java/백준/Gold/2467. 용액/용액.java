import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long[] solution;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        solution = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            solution[i] = Long.parseLong(st.nextToken());
        }
        
        int left = 0;
        int right = n-1;
        long minAbs = Long.MAX_VALUE;
        int ansLeft = 0;
        int ansRight = 0;
        
        while(left < right) {
            long sum = solution[left] + solution[right];
            
            if(Math.abs(sum) < minAbs) {
                minAbs = Math.abs(sum);
                ansLeft = left;
                ansRight = right;
            }
            
            if(sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        
        System.out.println(solution[ansLeft] + " " + solution[ansRight]);
    }
}