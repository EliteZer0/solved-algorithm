import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        LinkedList<String> permutations = new LinkedList<>();

        int length = input.length();

        // 세 구간으로 나누기 위한 두 개의 분할 지점 i, j를 설정
        for (int i = 1; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                String part1 = new StringBuilder(input.substring(0, i)).reverse().toString();
                String part2 = new StringBuilder(input.substring(i, j)).reverse().toString();
                String part3 = new StringBuilder(input.substring(j)).reverse().toString();

                permutations.add(part1 + part2 + part3);
            }
        }

        Collections.sort(permutations); // 사전순 정렬
        System.out.println(permutations.getFirst()); // 가장 앞에 있는 값 출력
    }
}