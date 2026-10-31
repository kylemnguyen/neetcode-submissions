class Solution {
    int[][] dp;
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        dp = new int[2][nums.length];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);

        return Math.max(dfs(0, 1, nums), dfs(1, 0, nums));
    }

    public int dfs(int i, int flag, int[] nums) {
        if(i >= nums.length || (flag == 1 && i == nums.length - 1)) return 0;
        if(dp[flag][i] != -1) return dp[flag][i];

        dp[flag][i] = Math.max(dfs(i + 1, flag, nums), nums[i] + dfs(i + 2, flag, nums));

        return dp[flag][i];
    }
}
