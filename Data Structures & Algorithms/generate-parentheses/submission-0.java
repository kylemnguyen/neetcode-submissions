class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(0, 0, n, ans, stack);
        return ans;
    }

    public void backtrack(int open_bracket, int close_bracket, int n, List<String> ans, StringBuilder stack) {
        if (open_bracket == close_bracket && open_bracket == n) {
            ans.add(stack.toString());
            return;
        }

        if(open_bracket < n) {
            stack.append('(');
            backtrack(open_bracket + 1, close_bracket, n, ans, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
        if(open_bracket > close_bracket) {
            stack.append(')');
            backtrack(open_bracket, close_bracket + 1, n, ans, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
