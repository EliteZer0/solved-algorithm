#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    int nums[100000];
    long sum = 0;
    
    for(int i = 0; i<N; i++){
        cin >> nums[i];
        sum += nums[i];
    }

    long ans = 0;
    for(int i = 0; i<N; i++){
        sum -= nums[i];
        ans += sum * nums[i];
    }
    
    cout << ans;
    return 0;
}