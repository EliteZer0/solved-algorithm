#include <bits/stdc++.h>
using namespace std;

struct town {
    int s, e, cost;

    town(int a, int b, int c){
        s = a;
        e = b;
        cost = c;
    }

    bool operator<(const town& t)const {
        return t.cost < cost;
    }
};

int parent[100001];
int set_size[100001];

int find(int x){
    if(parent[x] == x) return x;
    return parent[x] = find(parent[x]);
}

bool unite(int a, int b){
    a = find(a);
    b = find(b);

    if(a == b) return true;

    if(set_size[a] < set_size[b]){
        parent[a] = b;
        set_size[b] += set_size[a];
    }
    else{
        parent[b] = a;
        set_size[a] += set_size[b];
    }

    return false;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n, m;

    cin >> n >> m;

    for(int i = 1; i <= n; i++){
        parent[i] = i;
        set_size[i] = 1;
    }

    priority_queue<town> pq;

    for(int i = 0; i<m; i++){
        int a, b, c;
        cin >> a >> b >> c;
        
        pq.push(town(a, b, c));
    }

    int cnt = 0;
    int min_cost = 0;

    // 마지막에 연결될 마을만 분리될 한쪽 마을에 넣어버리면 최솟값
    // 따라서 간선 개수를 n-1이 아니라 n-2라고 생각하면 됨
    while(cnt != n-2){
        town cur = pq.top();
        pq.pop();

        if(cur.s == cur.e)
            continue;
        else{
            if(unite(cur.s, cur.e))
                continue;
            else{
                cnt ++;
                min_cost += cur.cost;
            }
        }
    }
    
    cout << min_cost;
    return 0;
}