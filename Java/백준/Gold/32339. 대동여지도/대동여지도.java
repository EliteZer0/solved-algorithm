import java.util.*;
import java.lang.*;
import java.io.*;

class spot {
    int s, e, cost, roadType;

    spot(int v1, int v2, int w, int k){
        this.s = v1;
        this.e = v2;
        this.cost = w;
        this.roadType = k;
    }
}

class Main {
    static int n, m;
    static int[] parents;
    static int[] size;
    static int[] roadPriority = new int[3];

    static final int PEDESTRIAN = 0;
    static final int HORSE = 1;
    static final int CARRIAGE = 2;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n+1];
        size = new int[n+1];
        makeset();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<3; i++){
            int x = Integer.parseInt(st.nextToken());
            roadPriority[x] = i;
        }

        Comparator<spot> compare = (a, b) -> {
            int p1 = roadPriority[a.roadType];
            int p2 = roadPriority[b.roadType];
            
            if (a.cost == b.cost)
                return p1 - p2;
            
            return a.cost - b.cost;
        };

        spot[] spotList = new spot[m];

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            spotList[i] = new spot(v1, v2, w, k);
        }

        Arrays.sort(spotList, compare);

        int idx = 0;
        int cnt = 0;

        int totalCost = 0;
        int[] roadCnt = new int[3];
        int[] roadCost = new int[3];
        while(cnt < n-1){
            spot cur = spotList[idx++];
            int s = cur.s;
            int e = cur.e;
            int cost = cur.cost;
            int roadType = cur.roadType;

            if(union(s, e)){
                cnt ++;
                totalCost += cost;

                if(roadType == PEDESTRIAN){
                    roadCnt[PEDESTRIAN] ++;
                    roadCost[PEDESTRIAN] += cost;
                }
                else if(roadType == HORSE){
                    roadCnt[HORSE] ++;
                    roadCost[HORSE] += cost;
                }
                else{
                    roadCnt[CARRIAGE] ++;
                    roadCost[CARRIAGE] += cost;
                }
            }
        }

        sb.append(totalCost).append("\n")
            .append(roadCnt[PEDESTRIAN]).append(' ').append(roadCost[PEDESTRIAN]).append("\n")
            .append(roadCnt[HORSE]).append(' ').append(roadCost[HORSE]).append("\n")
            .append(roadCnt[CARRIAGE]).append(' ').append(roadCost[CARRIAGE]);
        
        System.out.print(sb.toString());
    }

    static void makeset(){
        for(int i = 1; i<=n; i++){
            parents[i] = i;
            size[i] = 1;
        }
    }

    static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b) 
            return false;

        if(size[a] < size[b]){
            parents[a] = b;
            size[b] += size[a];
        }
        else{
            parents[b] = a;
            size[a] += size[b];
        }

        return true;
    }
}