class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;
        int maxProfit = 0;

        while(sell < prices.length) {
            int profit = prices[sell] - prices[buy];
            if(profit >= maxProfit) {
                maxProfit = profit;
            }
            if (profit < 0) {
                buy = sell;
            }
            sell++;
        }

        return maxProfit;        
    }
}
