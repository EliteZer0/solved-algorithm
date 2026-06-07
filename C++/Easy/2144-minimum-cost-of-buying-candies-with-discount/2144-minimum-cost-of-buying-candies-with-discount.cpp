#include <bits/stdc++.h>

class Solution {
public:
    int minimumCost(vector<int>& cost) {
        sort(cost.begin(), cost.end());
        int len = cost.size();
        int ans = 0;
        int cnt = 1;
        for(int i = len-1; i>=0; i--){
            if(cnt % 3 != 0){
                ans += cost[i];
            }
            cnt ++;
        }
        return ans;
    }
};