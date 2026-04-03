import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N,M,V;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static StringBuilder sb;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];

        for(int i = 1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }
        
        for(int i = 1; i<=N; i++){
            Collections.sort(graph[i]);
        }

        visited = new boolean[N+1];
        dfs(V);
        
        sb.append("\n");
        
        visited = new boolean[N+1];
        bfs(V);
        
        System.out.println(sb.toString());
    }

    static void dfs(int start){
        visited[start] = true;
        sb.append(start).append(" ");

        for(int next : graph[start]){
            if(!visited[next]) dfs(next);
        }
    }

    static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = true;

        while(!que.isEmpty()){
            int cur = que.poll();
            sb.append(cur).append(" ");
            for(int next : graph[cur]){
                if(!visited[next]){
                    que.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}