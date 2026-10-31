class Solution {
    public String longestPalindrome(String s) {
        int ansIdx = 0;
        int ansLen = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
    
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(s.charAt(i) == s.charAt(j) &&
                    (j - i <= 2 || dp[i + 1][j - 1])) {
                        
                        dp[i][j] = true;
                        if(ansLen < j - i + 1) {
                            ansLen = j - i + 1;
                            ansIdx = i;
                    }
                }
            }
        }

        return s.substring(ansIdx, ansIdx + ansLen);
    }
}
