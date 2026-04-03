#include <bits/stdc++.h>
using namespace std;

struct network {
    int s, e, cost;

    network(int a, int b, int c){
        s = a;
        e = b;
        cost = c;
    }

    bool operator<(const network& net)const {
        return net.cost < cost;
    }
};

int parent[1001];

int find(int x){
    if(parent[x] == x) return x;
    return parent[x] = find(parent[x]);
}

bool unite(int a, int b){
    a = find(a);
    b = find(b);

    if(a == b)
        return false;
    else {
        parent[b] = a;
    }

    return true;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n, m;
    cin >> n >> m;

    for(int i = 1; i <= n; i++){
        parent[i] = i;
    }

    priority_queue<network> pq;

    for(int i = 0; i < m; i++){
        int a, b, c;
        cin >> a >> b >> c;
        if(a == b) continue;
        pq.push(network(a, b, c));
    }

    int cnt = 0;
    int min_cost = 0;
    while(cnt != n-1){
        network cur = pq.top();
        pq.pop();
        if(unite(cur.s, cur.e)){
            cnt++;
            min_cost += cur.cost;
        }
    }
    
    cout << min_cost;
    return 0;
}