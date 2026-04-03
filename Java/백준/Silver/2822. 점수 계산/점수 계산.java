import java.util.*;
import java.io.*;

public class Main {
    private static class Question implements Comparable<Question> {
        int questionNum;
        int score;

        Question(int questionNum, int score){
            this.questionNum = questionNum;
            this.score = score;
        }

        @Override
        public int compareTo(Question other) {
            return other.score - this.score; // 내림차순 정렬
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Question> questions = new PriorityQueue<>();
        
        for(int i = 1; i<=8; i++){
            int idx = i;
            int score = Integer.parseInt(br.readLine());
            questions.add(new Question(idx,score));
        }
        
        
        int totalScore = 0;
        int[] questionNums = new int[5];
        
        for(int i = 0; i<5; i++){
            Question q = questions.poll();
            totalScore += q.score;
            questionNums[i] = q.questionNum;
        }

        Arrays.sort(questionNums);
        
        StringBuilder sb = new StringBuilder();
        sb.append(totalScore).append("\n");
        for(int n : questionNums){
            sb.append(n).append(" ");
        }
        System.out.println(sb.toString());    
    }
}