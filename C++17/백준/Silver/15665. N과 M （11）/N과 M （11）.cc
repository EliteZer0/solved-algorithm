#include <bits/stdc++.h>
using namespace std;

int n, m;
vector<int> nums;
vector<int> seq;

void find_seq(int depth){
    if(depth == m){
        for(int num : seq) cout << num << " ";
        cout << "\n";
        return;
    }

    int before = 0;
    for(int i = 0; i<n; i++){
        if(before == nums[i]) continue;
        seq[depth] = nums[i];
        before = nums[i];
        find_seq(depth+1);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m;
    
    nums.resize(n, 0);
    for(int i = 0; i<n; i++){
        cin >> nums[i];
    }
    sort(nums.begin(), nums.end());
    
    seq.resize(m, 0);
    
    find_seq(0);
    
    return 0;
}