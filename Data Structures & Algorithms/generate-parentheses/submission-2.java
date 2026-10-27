public class Solution {

    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n, new StringBuilder());
        return ans;
    }

    public void backtrack(int open_b, int close_b, int n, StringBuilder str) {
        if(open_b == close_b && open_b == n) {
            ans.add(str.toString());
            return;
        }

        if(open_b < n) {
            str.append('(');
            backtrack(open_b + 1, close_b, n, str);
            str.deleteCharAt(str.length() - 1);
        }
        if(close_b < open_b) {
            str.append(')');
            backtrack(open_b, close_b + 1, n, str);
            str.deleteCharAt(str.length() - 1);
        }

    }
}