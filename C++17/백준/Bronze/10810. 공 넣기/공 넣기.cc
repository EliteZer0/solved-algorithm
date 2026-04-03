#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;

    cin >> n >> m;

    vector<int> basket (n+1, 0);
    for(int i = 0; i<m; i++){
        int start, end, ball_num;
        cin >> start >> end >> ball_num;
        for(int j = start; j<=end; j++){
            basket[j] = ball_num;
        }
    }

    for(int i = 1; i<=n; i++){
        cout << basket[i] << ' ';
    }
    return 0;
}