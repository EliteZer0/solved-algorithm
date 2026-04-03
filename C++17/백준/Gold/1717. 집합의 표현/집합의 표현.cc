#include <bits/stdc++.h>
using namespace std;

int parent[1000001];
int set_size[1000001];

int find(int x) {
    if(parent[x] == x) return x;
    return parent[x] = find(parent[x]);
}

void unite(int a, int b) {
    a = find(a);
    b = find(b);

    if(a == b) return;

    if(set_size[a] < set_size[b]) {
        parent[a] = b;
        set_size[b] += set_size[a];
    }
    else {
        parent[b] = a;
        set_size[a] += set_size[b];
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n, m;
    cin >> n >> m;

    for(int i = 0; i <= n; i++){
        parent[i] = i;
        set_size[i] = 1;
    }

    for(int i = 0; i < m; i++){
        int cmd, a, b;
        cin >> cmd >> a >> b;
        if(cmd == 0){
            unite(a, b);
        }
        else{
            bool isUnited = find(a) == find(b) ? true : false;
            if(isUnited)
                cout << "YES";
            else
                cout << "NO";
            
            if(i < m-1)
                cout << "\n";
        }
        
    }
    
    return 0;
}