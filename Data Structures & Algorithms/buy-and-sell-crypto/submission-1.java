class Solution {
    public int maxProfit(int[] prices) {


        int buy = 0;
        int sell = 1;
        int maxProfit = 0;

        while (sell < prices.length) {
            int profit = prices[sell] - prices[buy];
            if(profit > maxProfit) {
                sell++;
                maxProfit = profit;
                continue;
            }
            if(profit < 0) {
                buy = sell;
                sell++;
                continue;
            } 
            sell++;
        }

        return maxProfit;

    }
}
