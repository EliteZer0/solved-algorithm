import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static char[] left = new char[26];
    static char[] right = new char[26];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char node = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            int idx = node - 'A';
            left[idx] = l;
            right[idx] = r;
        }

        preorder('A');
        sb.append('\n');
        inorder('A');
        sb.append('\n');
        postorder('A');

        System.out.print(sb);
    }

    static void preorder(char cur) {
        if (cur == '.') return;
        int idx = cur - 'A';
        sb.append(cur);
        preorder(left[idx]);
        preorder(right[idx]);
    }

    static void inorder(char cur) {
        if (cur == '.') return;
        int idx = cur - 'A';
        inorder(left[idx]);
        sb.append(cur);
        inorder(right[idx]);
    }

    static void postorder(char cur) {
        if (cur == '.') return;
        int idx = cur - 'A';
        postorder(left[idx]);
        postorder(right[idx]);
        sb.append(cur);
    }
}