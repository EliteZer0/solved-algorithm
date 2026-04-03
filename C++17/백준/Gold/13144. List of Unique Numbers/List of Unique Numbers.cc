#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    int nums[100000];

    for(int i = 0; i<N; i++){
        cin >> nums[i];
    }

    int left = 0;
    int right = 0;
    bool exist[100001];
    long ans = 0;
    
    while(right < N){
        if(exist[nums[right]]){
            exist[nums[left]] = false;
            left++;
        }else{
            exist[nums[right]] = true;
            ans += (right - left + 1);
            right++;
        }
    }
    cout << ans;
    return 0;
}