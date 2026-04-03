import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testroom = Integer.parseInt(br.readLine());
		int[] testTaker = new int[testroom];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < testroom; i++) {
			testTaker[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int mainSupervisor = Integer.parseInt(st.nextToken());
		int subSupervisor = Integer.parseInt(st.nextToken());
		
		long supervisorCnt = 0;
		for (int i = 0; i < testroom; i++) {
			testTaker[i] -= mainSupervisor;
			supervisorCnt++;
			if(testTaker[i]>0) {
				if(testTaker[i]%subSupervisor != 0) {
					supervisorCnt += (testTaker[i]/subSupervisor) + 1;
				}else {
					supervisorCnt += (testTaker[i]/subSupervisor);
				}
			}
			
		}
		System.out.println(supervisorCnt);
	}
}