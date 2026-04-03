import java.io.*;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(br.readLine());

        }

        Arrays.sort(arr);

        int answer = -1;

        for (int i = N - 1; i >= 2; i--) {

            int a = arr[i - 2];

            int b = arr[i - 1];

            int c = arr[i];

            if (a + b > c) { // 삼각형 가능

                answer = a + b + c;

                break;        // 가장 큰 합을 찾은 것이므로 바로 종료

            }

        }

        System.out.println(answer);

    }

}