import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int ans = 0;
        while(X>0){
            if(X==64){
                ans++;
                break;
            }
            if(X%2!=0) {
                ans++;
                X=X-1;
                if(X==0) break;
            }
            if(X%4!=0){
                ans++;
                X=X-2;
                if(X==0) break;
            }
            if(X%8!=0){
                ans++;
                X=X-4;
                if(X==0) break;
            }
            if(X%16!=0){
                ans++;
                X=X-8;
                if(X==0) break;
            }
            if(X%32!=0){
                ans++;
                X=X-16;
                if(X==0) break;
            }
            if(X%64!=0){
                ans++;
                X=X-32;
                if(X==0) break;
            }
        }
        System.out.println(ans);
    }
}