#include <bits/stdc++.h>
using namespace std;
/*
dp[i][state] : i 번째 열에서 state 저장
state -> 0 : 위 선택 1 : 아래 선택 2 : 둘 다 선택

dp[i][0] = max(dp[i-1][0], dp[i-1][2]) + cards[0][i];
dp[i][1] = max(dp[i-1][1], dp[i-1][2]) + cards[1][i];
dp[i][2] = max(dp[i-1][0], dp[i-1][1], dp[i-1][2]) + card[0][i] + cards[1][i];
*/
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    const long long INF = 4e14;
    int n;
    cin >> n;
    // 0-base
    int cards[2][200000];
    for(int i = 0; i<2; i++){
        for(int j = 0; j<n; j++){
            cin >> cards[i][j];
        }
    }
    
    // 대충 계산했을때 워스트 4*10^14 나와서
    // 고민하지 않고 long으로
    long long dp[200000][3];
    for(int i = 0; i < n; i++){
        for(int j = 0; j < 3; j++){
            dp[i][j] = -INF;
        }
    }
    
    dp[0][0] = cards[0][0];
    dp[0][2] = cards[0][0] + cards[1][0];
    for(int i = 1; i<n; i++){
        dp[i][0] = max(dp[i-1][0], dp[i-1][2]) + cards[0][i];
        dp[i][1] = max(dp[i-1][1], dp[i-1][2]) + cards[1][i];
        dp[i][2] = max(max(dp[i-1][0], dp[i-1][1]),dp[i-1][2]) + cards[0][i] + cards[1][i];   
    }

    // 마지막 열 마지막 칸에 도착해야함
    long long ans = max(dp[n-1][1], dp[n-1][2]);
    cout << ans;
    return 0;
}