import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double Ax = Double.parseDouble(st.nextToken());
        double Ay = Double.parseDouble(st.nextToken());
        double Bx = Double.parseDouble(st.nextToken());
        double By = Double.parseDouble(st.nextToken());
        double Cx = Double.parseDouble(st.nextToken());
        double Cy = Double.parseDouble(st.nextToken());
        double Dx = Double.parseDouble(st.nextToken());
        double Dy = Double.parseDouble(st.nextToken());

        double r0x = Ax - Cx;
        double r0y = Ay - Cy;

        double vx = (Bx - Ax) - (Dx - Cx);
        double vy = (By - Ay) - (Dy - Cy);

        double vv = vx * vx + vy * vy;
        double t;

        if (vv == 0.0) {
            t = 0.0;
        } else {
            double r0v = r0x * vx + r0y * vy;
            t = -r0v / vv;

            if (t < 0.0) t = 0.0;
            else if (t > 1.0) t = 1.0;
        }

        double rx = r0x + t * vx;
        double ry = r0y + t * vy;

        double ans = Math.sqrt(rx * rx + ry * ry);
        System.out.printf("%.10f\n", ans);
    }
}
