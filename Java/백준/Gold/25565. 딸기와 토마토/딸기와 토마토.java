import java.util.*;
import java.lang.*;
import java.io.*;

class LineInfo {
    int cnt;     // 해당 행과 열에 있는 1의 개수
    int first;   // 1이 처음 나온 위치
    int last;    // 1이 마지막으로 나온 위치

    LineInfo(int initFirst) {
        this.cnt = 0;
        this.first = initFirst;
        this.last = -1;
    }

    void update(int pos) {
        cnt++;
        first = Math.min(first, pos);
        last = Math.max(last, pos);
    }

    boolean isContinuous() {
        return cnt == last - first + 1;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LineInfo[] rows = new LineInfo[N];
        LineInfo[] cols = new LineInfo[M];

        for (int i = 0; i < N; i++)
            rows[i] = new LineInfo(M);
        for (int j = 0; j < M; j++)
            cols[j] = new LineInfo(N);

        int total = 0;
        int firstOneR = -1, firstOneC = -1;

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                int x = Integer.parseInt(st.nextToken());

                if (x == 1) {
                    total++;

                    if (firstOneR == -1) {
                        firstOneR = r;
                        firstOneC = c;
                    }

                    rows[r].update(c);
                    cols[c].update(r);
                }
            }
        }

        /* K == 1이면 각 사람은 한 칸만 심는다.
        total == 1 -> 두 사람이 같은 칸에 심음
        total == 2 -> 서로 다른 칸에 심음
        */
        if (K == 1) {
            if (total == 1) {
                sb.append(1).append('\n');
                sb.append(firstOneR + 1).append(' ').append(firstOneC + 1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
            System.out.print(sb.toString());
            return;
        }

        int occupiedRows = 0, occupiedCols = 0;
        int onlyRow = -1, onlyCol = -1;
        int rowsGt1 = 0, colsGt1 = 0;
        int specialRow = -1, specialCol = -1;

        for (int i = 0; i < N; i++) {
            if (rows[i].cnt > 0) {
                occupiedRows++;
                onlyRow = i;
            }
            if (rows[i].cnt > 1) {
                rowsGt1++;
                specialRow = i;
            }
        }

        for (int j = 0; j < M; j++) {
            if (cols[j].cnt > 0) {
                occupiedCols++;
                onlyCol = j;
            }
            if (cols[j].cnt > 1) {
                colsGt1++;
                specialCol = j;
            }
        }

        // 한 행에만 존재하는 경우
        if (occupiedRows == 1) {
            LineInfo row = rows[onlyRow];

            if (row.isContinuous()) {
                int unionLen = row.cnt;
                int overlap = 2 * K - unionLen;

                if (overlap > 0) {
                    int start = row.last - K + 1;
                    int end = row.first + K - 1;

                    sb.append(overlap).append('\n');
                    for (int c = start; c <= end; c++) {
                        sb.append(onlyRow + 1).append(' ').append(c + 1).append('\n');
                    }
                } else {
                    sb.append(0).append('\n');
                }
            } else {
                sb.append(0).append('\n');
            }

            System.out.print(sb.toString());
            return;
        }

        // 한 열에만 존재하는 경우
        if (occupiedCols == 1) {
            LineInfo col = cols[onlyCol];

            if (col.isContinuous()) {
                int unionLen = col.cnt;
                int overlap = 2 * K - unionLen;

                if (overlap > 0) {
                    int start = col.last - K + 1;
                    int end = col.first + K - 1;

                    sb.append(overlap).append('\n');
                    for (int r = start; r <= end; r++) {
                        sb.append(r + 1).append(' ').append(onlyCol + 1).append('\n');
                    }
                } else {
                    sb.append(0).append('\n');
                }
            } else {
                sb.append(0).append('\n');
            }

            System.out.print(sb.toString());
            return;
        }

        // 가로 + 세로
        if (rowsGt1 == 1 && colsGt1 == 1 && total == 2 * K - 1) {
            sb.append(1).append('\n');
            sb.append(specialRow + 1).append(' ').append(specialCol + 1).append('\n');
        } else {
            sb.append(0).append('\n');
        }

        System.out.print(sb.toString());
    }
}