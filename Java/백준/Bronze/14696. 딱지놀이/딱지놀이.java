import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tcNum = 1; tcNum < T+1; tcNum++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int aHave = Integer.parseInt(st.nextToken());
			int[] aCard = new int[aHave];
			for (int i = 0; i < aHave; i++) {
				aCard[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(aCard);
			
			st = new StringTokenizer(br.readLine());
			int bHave = Integer.parseInt(st.nextToken());
			int[] bCard = new int[bHave];
			for (int i = 0; i < bHave; i++) {
				bCard[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(bCard);
			
			int[] aCardCnt = new int[5];
			int[] bCardCnt = new int[5];
			
			for (int i = 0; i < aHave; i++) {
				aCardCnt[aCard[i]] ++;
			}
			
			for (int i = 0; i < bHave; i++) {
				bCardCnt[bCard[i]] ++;
			}
			
			boolean isAWin = false;
			boolean isDraw = false;
			
			for (int i = 4; i >= 0; i--) {
				if(aCardCnt[i]>bCardCnt[i]) {
					isAWin = true;
					break;
				} else if(aCardCnt[i]<bCardCnt[i]) {
					break;
				} else {
					if(i>0) {
						continue;
					}else {
						isDraw = true;
					}
				}
			}
			
			if(isAWin) {
				System.out.println("A");
			} else if(isDraw) {
				System.out.println("D");
			} else {
				System.out.println("B");
			}
		}
	}
}