import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();
        
        if (A.length < B.length) {
            char[] temp = A;
            A = B;
            B = temp;
        }

        int[] LCS = new int[B.length + 1];
        int pre;
        int temp;

        for (int i = 1; i <= A.length; i++) {
            pre = 0;
            for (int j = 1; j <= B.length; j++) {
                temp = LCS[j];
                if (A[i-1] == B[j-1]) {
                    LCS[j] = pre+1;
                } else {
                    LCS[j] = Math.max(LCS[j], LCS[j-1]);
                }
                pre = temp;
            }
        }
        
        System.out.println(LCS[B.length]);
    }
}