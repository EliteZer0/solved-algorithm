#include <bits/stdc++.h>
using namespace std;

struct planet {
    int s, e, cost;

    planet(int v1, int v2, int w){
        s = v1;
        e = v2;
        cost = w;
    }

    bool operator<(const planet& t) const {
        return t.cost > cost;
    }
};

int parents[1000];
int set_size[1000];

int find(int x) {
    if(parents[x] == x) return x;
    return parents[x] = find(parents[x]);
}

bool unite(int a, int b) {
    a = find(a);
    b = find(b);

    if(a == b) return false;

    if(set_size[a] < set_size[b]){
        parents[a] = b;
        set_size[b] += set_size[a];
    }
    else{
        parents[b] = a;
        set_size[a] += set_size[b];
    }

    return true;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;

    cin >> n;

    for(int i = 0; i < n; i++){
        parents[i] = i;
        set_size[i] = 1;
    }
    
    vector<planet> list;

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            int w;
            cin >> w;
            if(j>i)
                list.push_back(planet(i, j, w));
        }
    }

    sort(list.begin(), list.end());
    
    int cnt = 0;
    long long min_cost = 0;
    int idx = 0;
    while(cnt < n-1){
        planet cur = list[idx++];
        if(!unite(cur.s, cur.e))
                continue;
        else{
            cnt ++;
            min_cost += cur.cost;
        }
    }
    
    cout << min_cost;
    return 0;
}