import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        System.out.println(countIntersectingPairs(input));
    }
    
    public static int countIntersectingPairs(String s) {
        // 각 알파벳의 첫 번째와 두 번째 위치를 저장
        Map<Character, Integer> firstPos = new HashMap<>();
        Map<Character, Integer> secondPos = new HashMap<>();
        
        // 문자열을 순회하면서 각 알파벳의 위치 기록
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!firstPos.containsKey(c)) {
                firstPos.put(c, i);
            } else {
                secondPos.put(c, i);
            }
        }
        
        int intersectingPairs = 0;
        
        // 모든 소 쌍에 대해 경로가 교차하는지 확인
        for (char cow1 = 'A'; cow1 <= 'Z'; cow1++) {
            for (char cow2 = (char)(cow1 + 1); cow2 <= 'Z'; cow2++) {
                if (pathsIntersect(firstPos.get(cow1), secondPos.get(cow1),
                                firstPos.get(cow2), secondPos.get(cow2))) {
                    intersectingPairs++;
                }
            }
        }
        
        return intersectingPairs;
    }
    
    // 두 경로가 교차하는지 판단
    private static boolean pathsIntersect(int start1, int end1, int start2, int end2) {
        // 시작점과 끝점을 정렬 (작은 값이 start가 되도록)
        if (start1 > end1) {
            int temp = start1;
            start1 = end1;
            end1 = temp;
        }
        if (start2 > end2) {
            int temp = start2;
            start2 = end2;
            end2 = temp;
        }
        
        // cow1의 구간 [start1, end1] 사이에 cow2의 점이 몇 개 있는지 확인
        int pointsInside = 0;
        
        // start2가 구간 안에 있는지 확인
        if (start2 > start1 && start2 < end1) {
            pointsInside++;
        }
        
        // end2가 구간 안에 있는지 확인
        if (end2 > start1 && end2 < end1) {
            pointsInside++;
        }
        
        // 정확히 하나의 점만 있어야 경로가 교차함
        return pointsInside == 1;
    }
}