class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length() + 1][text2.length() + 1];
        for(int i = 0; i < text1.length(); i++){
            Arrays.fill(dp[i], -1);
        }

        return dfs(0,0,text1,text2);
    }

    public int dfs(int i, int j, String text1, String text2) {
        if(dp[i][j] != -1) return dp[i][j];
        if(i == text1.length() || j == text2.length()) return 0;
        if(text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + dfs(i + 1, j + 1, text1, text2);
        } else {
            dp[i][j] = Math.max(
                dfs(i + 1, j, text1, text2),
                dfs(i, j + 1, text1, text2)
            );
        }
        return dp[i][j];
    }
}
