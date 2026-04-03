import java.util.*;
import java.lang.*;
import java.io.*;

// 촌수 == 최단거리 -> BFS
class Main {
    static int n, m, start, end;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static class Person{
        int num;
        int cnt;
        
        Person(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        graph = new ArrayList[n+1];

        for(int i = 1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }
        
        System.out.println(bfs());
    }

    private static int bfs(){
        Queue<Person> que = new LinkedList<>();
        que.offer(new Person(start, 0));
        visited[start] = true;
        
        while(!que.isEmpty()){
            Person cur = que.poll();
            
            if(cur.num == end) return cur.cnt;
            
            for(int next : graph[cur.num]){
                if(!visited[next]){
                    visited[next] = true;
                    que.offer(new Person(next, cur.cnt+1));
                }
            }
        }
        return -1;
    }
}