import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] DNA = br.readLine().toCharArray();
        // A C G T
        int[] password = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<4; i++){
            password[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<P; i++){
            if(DNA[i] == 'A') password[0]--;
            else if(DNA[i] == 'C') password[1]--;
            else if(DNA[i] == 'G') password[2]--;
            else if(DNA[i] == 'T') password[3]--;
        }
        
        int cnt = 0;
        if(check(password)) cnt ++;
        for(int i = P; i<S; i++){
            if(DNA[i] == 'A') password[0]--;
            else if(DNA[i] == 'C') password[1]--;
            else if(DNA[i] == 'G') password[2]--;
            else if(DNA[i] == 'T') password[3]--;

            if(DNA[i-P] == 'A') password[0]++;
            else if(DNA[i-P] == 'C') password[1]++;
            else if(DNA[i-P] == 'G') password[2]++;
            else if(DNA[i-P] == 'T') password[3]++;
                
            if(check(password)) cnt ++;
        }
        
        System.out.println(cnt);
    }

    static boolean check(int[] arr){
        return arr[0] <= 0 && arr[1] <= 0 && arr[2] <= 0 && arr[3] <= 0;
    }
}