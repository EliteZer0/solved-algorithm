import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numStr = br.readLine();
        int[] nums = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            nums[i] = numStr.charAt(i) - '0';
        }
        
        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();
        for (int i = numStr.length()-1; i >= 0; i--) {
            sb.append(nums[i]);
        }

        System.out.print(sb.toString());
    }
}