class Solution {
    int totalSum;
    int[][] dp;

    public int findTargetSumWays(int[] nums, int target) {
        totalSum = 0;
        for (int num : nums) totalSum += num;
        dp = new int[nums.length + 1][totalSum * 2 + 1];

        for(int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return backtrack(0, 0, nums, target);
    }

    public int backtrack(int i, int total, int[] nums, int target) {
        if(i >= nums.length) return total == target ? 1 : 0;
        if(dp[i][totalSum + total] != Integer.MIN_VALUE) return dp[i][totalSum + total];

        dp[i][totalSum + total] = backtrack(i + 1, total + nums[i], nums, target) + backtrack(i + 1, total - nums[i], nums, target);

        return dp[i][totalSum + total];
    }
}
