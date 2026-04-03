#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    int time[1000];

    for(int i = 0; i<N; i++){
        cin >> time[i];
    }
    sort(time, time+N);

    int ans = 0;
    for(int i = 0; i<N; i++){
        ans += time[i]*(N-i);
    }
    cout << ans;
    return 0;
}