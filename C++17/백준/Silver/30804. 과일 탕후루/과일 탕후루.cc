#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N;
    cin >> N;
    vector<int> arr(N);
    int exist[10] = {0};
    
    for(int i = 0; i<N; i++){
        cin >> arr[i];
    }

    int left = 0;
    int right = 0;
    // 과일 2개가 각각 1개 남는 경우가 최소값
    int ans = 1;
    int type = 1;
    exist[arr[0]]++;

    while(left<N){
        while(right<N-1){
            int next = arr[right + 1];

            // 다음 과일을 넣으면 3종류가 되는 경우 멈춤
            if(exist[next] == 0 && type == 2) break;
            
            right++;
            if(exist[arr[right]] == 0) type++;
            exist[arr[right]]++;
            
            int cnt = right-left+1;
            ans = max(ans, cnt);
        }
        exist[arr[left]]--;
        if(exist[arr[left]] == 0) {
            type--;
        }
        left++;
    }
    
    cout << ans;
    return 0;
}