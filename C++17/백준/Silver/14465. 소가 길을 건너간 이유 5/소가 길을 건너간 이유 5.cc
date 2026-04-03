#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N, K, B;
    cin >> N >> K >> B;
    bool isBorken[1000001] = {false};

    for(int i = 0; i<B; i++){
        int idx;
        cin >> idx;
        isBorken[idx] = true;
    }

    int cnt = 0;
    int ans = 0;

    for(int i = 1; i<=K; i++){
        if(isBorken[i]) cnt++;
    }

    ans = cnt;
    for(int i = K+1; i<=N; i++){
        if(isBorken[i]) cnt++;
        if(isBorken[i-K]) cnt--;
        ans = min(ans, cnt);
    }
    
    cout << ans;
    return 0;
}