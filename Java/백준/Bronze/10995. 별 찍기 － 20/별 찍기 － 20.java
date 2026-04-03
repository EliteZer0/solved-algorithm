import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());		
		
		for (int i = 1; i <= N; i++) {
			if(i%2 != 0) {
				for (int j = 0; j < N; j++) {
					System.out.print("* ");
				}
				System.out.println();
			}
			else {
				for (int j = 0; j < N; j++) {
					System.out.print(" *");
				}
				System.out.println();
			}
		}
	}
}