#include <bits/stdc++.h>
using namespace std;

int parent[1000001];
int set_size[1000001];

int find(int x) {
    if(parent[x] == x) return x;
    return parent[x] = find(parent[x]);
}

bool unite(int a, int b) {
    a = find(a);
    b = find(b);

    if(a == b) {
        return true;
    }

    if(set_size[a] < set_size[b]) {
        parent[a] = b;
        set_size[b] += set_size[a];
    }
    else {
        parent[b] = a;
        set_size[a] += set_size[b];
    }

    return false;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n, m, turn;
    cin >> n >> m;

    for(int i = 0; i < n; i++){
        parent[i] = i;
        set_size[i] = 1;
    }

    for(int i = 1; i <= m; i++){
        int a, b;
        cin >> a >> b;
        
        if(unite(a, b)){
            cout << i;
            return 0;
        }
    }

    cout << 0;

    return 0;
}