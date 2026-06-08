class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int prices_len = prices.size();
        int min_price = 10001;
        int max_profit = 0;
        
        for(int i = 0; i < prices_len; i++){
            min_price = min(min_price, prices[i]);
            max_profit = max(max_profit, prices[i] - min_price);
        }

        return max_profit;
    }
};