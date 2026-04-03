import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int idx = Integer.parseInt(br.readLine()) - 1;
		char c = input.charAt(idx);

		System.out.println(c);
	}
}