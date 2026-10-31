class Solution {
    public int numDecodings(String s) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1);

        return dfs(s, 0, dp);
    }

    public int dfs(String s, int i, HashMap<Integer, Integer> dp) {
        if(dp.containsKey(i)) return dp.get(i);
        if(s.charAt(i) == '0') return 0;

        int ans = dfs(s, i + 1, dp);
        if(i + 1 < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' &&
            s.charAt(i + 1) < '7')) {
                ans += dfs(s, i + 2, dp);
        }
        dp.put(i, ans);
        return ans;
    }
}
