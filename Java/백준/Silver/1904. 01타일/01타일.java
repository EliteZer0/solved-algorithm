import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] fibo = new int[1000001];
		fibo[1] = 1;
		fibo[2] = 2;
		for (int i = 3; i <= n; i++) {
			fibo[i] = (fibo[i-1] + fibo[i-2])%15746;//나머지 저장해서 연산해도 어차피 똑같음
		}
		int answer = fibo[n];
		System.out.println(answer);
	}
}