#include <bits/stdc++.h>
using namespace std;

struct house {
    int s, e, cost;

    bool operator<(const house& t)const {
        return t.cost > cost;
    }
};

int parent[200001];
int set_size[200001];

int find(int x){
    if(parent[x] == x) return x;
    return parent[x] = find(parent[x]);
}

bool unite(int a, int b){
    a = find(a);
    b = find(b);

    if(a == b) return false;

    if(set_size[a] < set_size[b]){
        parent[a] = b;
        set_size[b] += set_size[a];
    }
    else{
        parent[b] = a;
        set_size[a] += set_size[b];
    }

    return true;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    while(true){
        int m, n;

        cin >> m >> n;

        if(m == 0 && n == 0)
            break;
    
        for(int i = 0; i < m; i++){
            parent[i] = i;
            set_size[i] = 1;
        }
    
        vector<house> street_list(n);
    
        int total_cost = 0;
        for(int i = 0; i<n; i++){
            int a, b, c;
            cin >> a >> b >> c;
            
            street_list[i] = {a, b, c};
            total_cost += c;
        }

        sort(street_list.begin(), street_list.end());

        int cnt = 0;
        int min_cost = 0;
        int idx = 0;
    
        while(cnt < m-1){
            house cur = street_list[idx++];
            
            if(!unite(cur.s, cur.e))
                continue;
            else{
                cnt ++;
                min_cost += cur.cost;
            }
        }
        
        cout << total_cost - min_cost << "\n";
    }
    
    return 0;
}