#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N, M;
    cin >> N >> M;
    vector<int> hole(N);

    for(int i = 0; i<N; i++){
        cin >> hole[i];
    }

    int left = 0;
    int right = 0;
    int sum = 0;
    int ans = 0;
    while(right<N){
        sum += hole[right];

        while(sum > M){
            sum -= hole[left];
            left++;
        }

        ans = max(ans, sum);
        right++;
    }
    
    cout << ans;
    return 0;
}