import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] people = new int[N][2];

        StringTokenizer st;
		for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
			people[i][0] = Integer.parseInt(st.nextToken());	// [i][0] : 몸무게 
			people[i][1] = Integer.parseInt(st.nextToken());	// [i][1] : 키 
		}
		
		StringBuilder sb = new StringBuilder();		
		for(int i = 0; i < N; i++) {
			int rank = 1;
			
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				if (people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
					rank++;
				}
			}
            sb.append(rank).append(" ");
		}
        
		System.out.print(sb.toString());
	}
}