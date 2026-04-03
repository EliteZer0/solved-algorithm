import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int maxFive = n/5;
        int minTwo = 0;
        if((n-5*maxFive)%2 != 0){
            maxFive--;
        }
        if(maxFive<0) System.out.println(-1);
        else{
            minTwo = (n-5*maxFive)/2;
            int ans = maxFive+minTwo;
            System.out.println(ans);
        }
    }
}