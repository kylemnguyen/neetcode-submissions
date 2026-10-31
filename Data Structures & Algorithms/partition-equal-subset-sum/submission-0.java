class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        int target = 0;
        int n = nums.length;
        for(int num : nums) {
            total+=num;
        }
        if(total % 2 != 0) return false;
        // can't divide an odd number equally in half
        target = total / 2;

        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true; 
        }

        for (int i = 1; i <= n; i++) {
            for(int j = 1; j <= target; j++) {
                if(nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];
    }
}
