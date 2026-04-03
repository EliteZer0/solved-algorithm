#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N, K;
    cin >> N >> K;
    vector<int> arr(N);

    for(int i = 0; i<N; i++){
        cin >> arr[i];
    }

    int sum = 0;
    int ans = 0;

    for(int i = 0; i<K; i++){
        sum += arr[i];
    }

    ans = sum;
    for(int i = K; i<N; i++){
        sum += arr[i];
        sum -= arr[i-K];
        ans = max(ans, sum);
    }
    
    cout << ans;
    return 0;
}