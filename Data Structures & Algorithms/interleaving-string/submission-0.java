class Solution {
    private Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length())
            return false;
        dp = new Boolean[m + 1][n + 1];
        return dfs(0, 0, 0, s1, s2, s3);
    }
    public boolean dfs(int i, int j, int k, String s1, String s2, String s3) {
        if (k == s3.length()) {
            return (i == s1.length() && j == s2.length());
        }
        if (dp[i][j] != null)
            return dp[i][j];
        boolean ans = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            ans = dfs(i + 1, j, k + 1, s1, s2, s3);
        }
        if (!ans && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            ans = dfs(i, j + 1, k + 1, s1, s2, s3);
        }

        dp[i][j] = ans;
        return ans;
    }
}
