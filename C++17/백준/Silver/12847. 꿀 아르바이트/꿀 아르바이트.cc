#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n, m;
    cin >> n >> m;
    vector<int> pay(n);

    for(int i = 0; i<n; i++){
        cin >> pay[i];
    }

    long sum = 0;
    long ans = 0;

    for(int i = 0; i<m; i++){
        sum += pay[i];
    }

    ans = sum;
    for(int i = m; i<n; i++){
        sum += pay[i];
        sum -= pay[i-m];
        ans = max(ans, sum);
    }
    
    cout << ans;
    return 0;
}