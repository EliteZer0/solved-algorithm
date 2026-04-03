#include <bits/stdc++.h>
using namespace std;

int main() {
    int N, K;
    cin >> N >> K;
    
    int coin[10];
    int maxW = 0;
    int maxIdx = 0;
    for(int i = 0; i<N; i++){
        cin >> coin[i];
        if(coin[i]<=K) {
            maxW = coin[i];
            maxIdx = i;
        }
    }

    int ans = 0;
    while(K>0){
        int q = K/maxW;
        ans += q;
        K -= maxW * q;
        if(K==0) break;
        for(int i = maxIdx - 1; i>=0; i--){
            if(coin[i]<=K) {
                maxW = coin[i];
                maxIdx = i;
                break;
            }
        }
    }
    cout << ans;
    return 0;
}