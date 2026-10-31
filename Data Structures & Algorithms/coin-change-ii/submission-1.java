class Solution {
    HashMap<String, Integer> dp = new HashMap<>();
    public int change(int amount, int[] coins) {
        return dfs(coins, amount, 0);
    }

    public int dfs(int[] coins, int amount, int i) {
        if (amount == 0) return 1;
        if (amount < 0 || i == coins.length) return 0;

        String key = i + "," + amount;
        if(dp.containsKey(key)) return dp.get(key);

        int ways = dfs(coins, amount, i + 1) + dfs(coins, amount - coins[i], i);
        dp.put(key, ways);
        return ways;
    }
}
