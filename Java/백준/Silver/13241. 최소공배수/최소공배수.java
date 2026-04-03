import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        

        String[] input = br.readLine().split(" ");

        long A = Long.parseLong(input[0]);

        long B = Long.parseLong(input[1]);

        

        long lcm = (A * B) / gcd(A, B);

        

        sb.append(lcm);

        System.out.print(sb.toString());

        
    }

    

    private static long gcd(long a, long b) {

        while (b != 0) {

            long temp = b;

            b = a % b;

            a = temp;

        }

        return a;

    }

}