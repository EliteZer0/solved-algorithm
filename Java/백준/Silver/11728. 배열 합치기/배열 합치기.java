import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++){
            arr[N+i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N+M; i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}