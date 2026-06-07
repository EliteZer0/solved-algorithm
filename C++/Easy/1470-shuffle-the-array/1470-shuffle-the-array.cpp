class Solution {
public:
    vector<int> shuffle(vector<int>& nums, int n) {
        vector<int> ans(n*2);
        int idx = 0;
        for(int i = 0; i<n; i++){
            ans[idx++] = nums[i];
            ans[idx++] = nums[i+n];
        }

        return ans;
    }
};