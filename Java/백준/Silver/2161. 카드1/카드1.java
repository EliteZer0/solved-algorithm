import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        // 1부터 N까지 큐에 삽입
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        // 카드가 한 장 남을 때까지 반복
        while (queue.size() > 1) {
            result.add(queue.poll());       // 맨 앞 카드를 버림
            queue.offer(queue.poll());      // 그 다음 카드를 맨 뒤로 보냄
        }

        // 결과 출력
        for (int num : result) {
            System.out.print(num + " ");
        }
        // 마지막 남은 카드 출력
        System.out.print(queue.poll());
    }
}