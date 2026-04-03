import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int nowYear = Integer.parseInt(st1.nextToken());
        int nowMonth = Integer.parseInt(st1.nextToken());
        int nowDay = Integer.parseInt(st1.nextToken());

        int endYear = Integer.parseInt(st2.nextToken());
        int endMonth = Integer.parseInt(st2.nextToken());
        int endDay = Integer.parseInt(st2.nextToken());

        if (endYear > nowYear + 1000
                || (endYear == nowYear + 1000 && endMonth > nowMonth)
                || (endYear == nowYear + 1000 && endMonth == nowMonth && endDay >= nowDay)) {
            System.out.println("gg");
        } else {
            int startDays = getDays(nowYear, nowMonth, nowDay);
            int endDays = getDays(endYear, endMonth, endDay);
            System.out.println("D-" + (endDays - startDays));
        }
    }

    static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    static int getDays(int year, int month, int day) {
        int[] monthTotal = {31,28,31,30,31,30,31,31,30,31,30,31};
        int days = 0;

        for (int y = 1; y < year; y++) {
            days += isLeap(y) ? 366 : 365;
        }

        for (int m = 1; m < month; m++) {
            days += monthTotal[m - 1];
            if (m == 2 && isLeap(year)) {
                days += 1;
            }
        }

        days += day;
        return days;
    }
}