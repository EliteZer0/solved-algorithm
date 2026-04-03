import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<T; i++){
            char[] input = br.readLine().toCharArray();
            int length = input.length;
            int letterSize = (int)Math.sqrt(length);
            StringBuilder sb = new StringBuilder();
            for(int j = letterSize-1; j>=0; j--){
                for(int k = 0; k<letterSize; k++){
                    sb.append(input[j+letterSize*k]);
                }
            }
            System.out.println(sb.toString());
        }
    }
}