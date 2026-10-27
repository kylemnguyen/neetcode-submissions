class Solution {
    List<String> ans = new ArrayList<>();
    HashMap<Integer, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) {
            return ans;
        }
        
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        backtrack(digits, "", 0);
        return ans;

    }

    public void backtrack(String digits, String curStr, int i) {
        if(curStr.length() == digits.length()) {
            ans.add(curStr);
            return;
        }

        String letters = map.get(Integer.valueOf(digits.charAt(i) - '0'));

        for(char c : letters.toCharArray()) {
            backtrack(digits, curStr + c, i + 1);
        }
    }
}
