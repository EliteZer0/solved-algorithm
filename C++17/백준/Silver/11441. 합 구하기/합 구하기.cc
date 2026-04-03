#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    int sum[100001];
    for(int i = 1; i<=N; i++){
        int x;
        cin >> x;

        sum[i] = sum[i-1] + x;
    }

    int M;
    cin >> M;

    while(M--){
        int start, end;
        cin >> start >> end;

        int ans = sum[end] - sum[start-1];
        cout << ans << "\n";
    }
    return 0;
}