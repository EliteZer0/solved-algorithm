#include <bits/stdc++.h>
using namespace std;
int n, m;
vector<bool> visited;
vector<int> seq;

void find_seq(int idx, int depth){
    if(depth == m){
        for(int num : seq)
            cout << num << " ";
        cout << "\n";
        return;
    }

    for(int i = idx; i<=n; i++){
        seq[depth] = i;
        find_seq(i, depth+1);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m;
    visited.resize(n+1, false);
    seq.resize(m, 0);

    find_seq(1, 0);
    return 0;
}