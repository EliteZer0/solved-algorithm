import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static class Party{
        int size;
        List<Integer> member;

        Party(int size, List<Integer> member){
            this.size = size;
            this.member = member;
        }
        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] isKnew = new boolean[N+1];
        Party[] partyList = new Party[M];

        st = new StringTokenizer(br.readLine());
        int sincereCnt = Integer.parseInt(st.nextToken());

        if(sincereCnt == 0){
            System.out.println(M);
            return;
        } else{
            for(int i = 0; i<sincereCnt; i++){
                int sincerePerson = Integer.parseInt(st.nextToken());
                isKnew[sincerePerson] = true;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int people = Integer.parseInt(st.nextToken());
            partyList[i] = new Party(people, new ArrayList<>());

            for (int j = 0; j < people; j++) {
                int person = Integer.parseInt(st.nextToken());
                partyList[i].member.add(person);
            }
        }

        boolean changed = true;
        while (changed) {
            changed = false;

            for (int i = 0; i < M; i++) {
                boolean hasTruth = false;

                for (int j = 0; j < partyList[i].size; j++) {
                    int person = partyList[i].member.get(j);
                    if (isKnew[person]) {
                        hasTruth = true;
                        break;
                    }
                }

                if (hasTruth) {
                    for (int p : partyList[i].member) {
                        if (!isKnew[p]) {
                            isKnew[p] = true;
                            changed = true;
                        }
                    }
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i<M; i++){
            boolean canSay = true;
            for(int j = 0; j<partyList[i].size; j++){
                int person = partyList[i].member.get(j);
                if(isKnew[person]){
                    canSay = false;
                    break;
                }
            }
            if(canSay) cnt++;
        }
        
        System.out.println(cnt);
    }
}