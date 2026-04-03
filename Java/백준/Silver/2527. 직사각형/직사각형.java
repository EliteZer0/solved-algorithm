import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t<4; t++){
            st = new StringTokenizer(br.readLine());
            int[][] points = new int[4][2];
            for(int pos = 0; pos<4; pos++){
                for(int coord = 0; coord<2; coord++){
                    points[pos][coord] = Integer.parseInt(st.nextToken());
                }
            }
            int Ax = points[0][0];
            int Ay = points[0][1];
            int Bx = points[1][0];
            int By = points[1][1];
            int Cx = points[2][0];
            int Cy = points[2][1];
            int Dx = points[3][0];
            int Dy = points[3][1];

            if(isRac(Ax, Ay, Bx, By, Cx, Cy, Dx, Dy)){
                sb.append("a").append("\n");
                continue;
            }
            else if(isLine(Ax, Ay, Bx, By, Cx, Cy, Dx, Dy)){
                sb.append("b").append("\n");
                continue;
            }
            else if(isPoint(Ax, Ay, Bx, By, Cx, Cy, Dx, Dy)){
                sb.append("c").append("\n");
                continue;
            }
            else{
                sb.append("d").append("\n");
                continue;
            }
        }
        
        System.out.println(sb.toString());
    }

    private static boolean isRac(int x1, int y1, int p1, int q1, int x2, int y2, int p2, int q2) {
        int overlapW = Math.min(p1, p2) - Math.max(x1, x2);
        int overlapH = Math.min(q1, q2) - Math.max(y1, y2);
    
        return overlapW > 0 && overlapH > 0;
    }
    
    private static boolean isLine(int x1, int y1, int p1, int q1, int x2, int y2, int p2, int q2) {
        int overlapW = Math.min(p1, p2) - Math.max(x1, x2);
        int overlapH = Math.min(q1, q2) - Math.max(y1, y2);
    
        return (overlapW == 0 && overlapH > 0) || (overlapW > 0 && overlapH == 0);
    }
    
    private static boolean isPoint(int x1, int y1, int p1, int q1, int x2, int y2, int p2, int q2) {
        int overlapW = Math.min(p1, p2) - Math.max(x1, x2);
        int overlapH = Math.min(q1, q2) - Math.max(y1, y2);
    
        return overlapW == 0 && overlapH == 0;
    }
}