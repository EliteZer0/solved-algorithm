#include <bits/stdc++.h>
using namespace std;

const int mod = 1000000009;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n;
    cin >> n;
    
    // len, r
    long long dp[33334][3];
    dp[1][0] = 0;
    dp[1][1] = 1;
    dp[1][2] = 1;

    for(int i = 2; i <= n; i++) {
        dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % mod;
        dp[i][1] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % mod;
        dp[i][2] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % mod;
    }
    
    cout << dp[n][0];
    return 0;
}