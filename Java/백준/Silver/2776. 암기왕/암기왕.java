import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc<T; tc++){
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int[] note1 = new int[N];
            for(int i = 0; i<N; i++){
                note1[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(note1);

            int M = Integer.parseInt(br.readLine());
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<M; i++){
                int x = Integer.parseInt(st.nextToken());
                int left = 0;
                int right = N-1;
                boolean exist = false;
                
                while(left<=right){
                    int mid = (left+right)/2;
                    
                    if(note1[mid] == x){
                        exist = true;
                        break;
                    }
                        
                    else if(note1[mid] > x) right = mid-1;
                    else left = mid+1;
                }

                if(exist) sb.append(1);
                else sb.append(0);
                sb.append("\n");
            }
        }
        
        System.out.println(sb.toString());
    }
}