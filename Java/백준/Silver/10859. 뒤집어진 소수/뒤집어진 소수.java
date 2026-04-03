import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine().trim();
        
        // 입력된 수가 소수가 아니면
        if(!isPrime(Long.parseLong(input))){
            System.out.println("no");
            return;
        }

        char[] nums = input.toCharArray();
        int len = nums.length;
        for(int i = len-1; i>=0; i--){
            char c = nums[i];
            if (c=='0'||c=='1'||c=='2'||c=='5'||c=='8') sb.append(c);
            else if (c=='6') sb.append('9');
            else if (c=='9') sb.append('6');
            // 3,4,7 포함 나머지
            else {
                System.out.println("no");
                return;
            }
        }

        if(!isPrime(Long.parseLong(sb.toString()))) System.out.println("no");
        else System.out.println("yes");
    }

    private static boolean isPrime(long n){
        if(n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        // 6k ± 1 형태만 검사
        for(long i = 5; i * i <= n; i += 6){
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}