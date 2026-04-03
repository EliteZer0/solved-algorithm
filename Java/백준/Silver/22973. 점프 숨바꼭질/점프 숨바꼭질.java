import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long K = Long.parseLong(br.readLine());

        if (K == 0) {
            System.out.println(0);
            return;
        }

        if ((K & 1L) == 0L) {        
            System.out.println(-1);
            return;
        }

        long m = Math.abs(K) + 1;

        int n = 64 - Long.numberOfLeadingZeros(m - 1);
        
        System.out.println(n);
    }
}