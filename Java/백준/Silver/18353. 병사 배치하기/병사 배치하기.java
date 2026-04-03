import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] soldiers = new int[N];
        for(int i = 0; i < N; i++){
            soldiers[i] = Integer.parseInt(st.nextToken());
        }
        
        ArrayList<Integer> lds = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            int position = Collections.binarySearch(lds, soldiers[i], Collections.reverseOrder());
            if(position < 0) position = -(position + 1);
            
            if(position >= lds.size()) lds.add(soldiers[i]);
            else lds.set(position, soldiers[i]);
        }
        
        System.out.println(N - lds.size());
    }
}