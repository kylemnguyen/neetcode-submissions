class Solution {
    
    private List<List<String>> ans;
    private List<String> subset;
    
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        subset = new ArrayList<>();
        dfs(s, subset, 0);
        return ans;
    }

    private void dfs(String s, List<String> subset, int i) {
        if(i >= s.length()) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        for(int j = i; j < s.length(); j++) {
            if(isPalindrome(s.substring(i, j + 1))) {
                subset.add(s.substring(i, j + 1));
                dfs(s, subset, j+1);
                subset.remove(subset.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
