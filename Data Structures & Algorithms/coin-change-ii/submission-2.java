class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(0, amount, coins, dp);
    }
    
    public int dfs(int i, int amount, int[] coins, int[][] dp) {
        if(amount == 0) return 1;
        if(i >= coins.length) return 0;
        if(dp[i][amount] != -1) return dp[i][amount];

        int ans = 0;
        if(amount >= coins[i]) {
            ans = dfs(i, amount - coins[i], coins, dp) + dfs(i + 1, amount, coins, dp);

        }
        dp[i][amount] = ans;

        return ans;

    }
}
