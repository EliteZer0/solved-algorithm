#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N, K;
    cin >> N >> K;
    vector<bool> isLion(N);

    for(int i = 0; i<N; i++){
        int doll;
        cin >> doll;
        if(doll == 1) isLion[i] = true;
        else isLion[i] = false;
    }

    int cnt = 0;
    int ans = 987654321;
    int left = 0;
    int right = 0;

    while(left<N){
        while(cnt<K && right<N){
            if(isLion[right]) cnt++;
            right++;
        }
        
        if(cnt>=K) {
            ans = min(ans, right-left);
        }
        
        if(isLion[left]) {
            cnt--;
        }
        
        left++;
    }

    if(ans == 987654321) cout << -1;
    else cout << ans;
    
    return 0;
}