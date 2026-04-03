import java.util.*;
import java.io.*;

public class Main {
    static class Cordinates implements Comparable<Cordinates> {
        private int x;
        private int y;

        public Cordinates(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Cordinates o){
            if (this.x != o.x) return Integer.compare(this.x, o.x);
            return Integer.compare(this.y, o.y);
        }

        /*
        @Override
        public int compareTo(Cordinates o){
            if (this.x > o.x) return 1;
            else if (this.x < o.x) return -1;
            else {
                // x값이 같을 때 y값 비교
                if (this.y > o.y) return 1;
                else if (this.y < o.y) return -1;
                else return 0;
            }
        }
        */
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        List<Cordinates> cordinatesList = new ArrayList<>();
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Cordinates newCordinates = new Cordinates(x, y);
            cordinatesList.add(newCordinates);
        }

        Collections.sort(cordinatesList);
        
        StringBuilder sb = new StringBuilder();
        for (Cordinates c : cordinatesList) {
            sb.append(c.x).append(" ").append(c.y).append("\n");
        }
        System.out.print(sb.toString());
    }
}