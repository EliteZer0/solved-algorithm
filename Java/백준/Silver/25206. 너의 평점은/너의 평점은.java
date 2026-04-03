import java.io.*;

public class Main {
public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    double totalScore = 0.0;  // (학점 × 과목평점)의 합
    double totalCredit = 0.0; // 학점의 총합
    
    // 20줄의 과목 정보를 읽어서 처리
    for (int i = 0; i < 20; i++) {
        String[] input = br.readLine().split(" ");
        String courseName = input[0];
        double credit = Double.parseDouble(input[1]);
        String grade = input[2];
        
        // P 등급인 경우 계산에서 제외
        if (grade.equals("P")) {
            continue;
        }
        
        double gradePoint = 0.0;
        
        // 등급에 따른 과목평점 계산
        if (grade.equals("A+")) {
            gradePoint = 4.5;
        } else if (grade.equals("A0")) {
            gradePoint = 4.0;
        } else if (grade.equals("B+")) {
            gradePoint = 3.5;
        } else if (grade.equals("B0")) {
            gradePoint = 3.0;
        } else if (grade.equals("C+")) {
            gradePoint = 2.5;
        } else if (grade.equals("C0")) {
            gradePoint = 2.0;
        } else if (grade.equals("D+")) {
            gradePoint = 1.5;
        } else if (grade.equals("D0")) {
            gradePoint = 1.0;
        } else if (grade.equals("F")) {
            gradePoint = 0.0;
        }
        
        // 전공평점 계산을 위한 값들 누적
        totalScore += credit * gradePoint;
        totalCredit += credit;
    }
    
    // 전공평점 = (학점 × 과목평점)의 합 / 학점의 총합
    double gpa = totalScore / totalCredit;
    
    System.out.println(gpa);
}

}