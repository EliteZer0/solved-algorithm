import java.util.*;
import java.lang.*;
import java.io.*;

/*
Deque는 정렬 유지 불가
삽입할 때마다 정렬하려면 시간 초과 날 듯
PriorityQueue 하나로도 안 됨 최소 두개는 있어야함
TreeMap에 이런 메소드 있음
map.firstKey();
map.lastKey();
대신 중복처리가 안돼서 카운트를 함께 저장
*/

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t<T; t++){
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for(int i = 0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if (c == 'I') {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;

                    int key = (n == 1) ? map.lastKey() : map.firstKey();
                    int cnt = map.get(key);

                    if (cnt == 1) map.remove(key);
                    else map.put(key, cnt - 1);
                }
            }
            if (map.isEmpty()) sb.append("EMPTY\n");
            else sb.append(map.lastKey()).append(' ').append(map.firstKey()).append('\n');
        }
        System.out.println(sb.toString());
    }
}