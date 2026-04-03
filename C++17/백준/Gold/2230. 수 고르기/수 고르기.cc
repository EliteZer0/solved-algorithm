#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M;
    cin >> N >> M;

    int nums[100000];

    for(int i = 0; i<N; i++){
        cin >> nums[i];
    }
    sort(nums, nums+N);

    int left = 0;
    int right = 0;
    // 항상 차이가 M 이상, 차의 최댓값은 10억
    // 정렬했으니 맨 앞과 맨 끝의 차가 최대
    int ans = nums[N-1] - nums[0];
    
    while(left < N){
        int gap = nums[right] - nums[left];
        while(gap < M) {
            right ++;
            gap = nums[right] - nums[left];
        }
        ans = min(ans, gap);
        left++;
    }
    cout << ans;
    return 0;
}