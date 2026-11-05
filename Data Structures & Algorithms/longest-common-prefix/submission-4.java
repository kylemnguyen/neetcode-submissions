class Solution {
    public String longestCommonPrefix(String[] strs) {
        String smallestStr = strs[0];
        if(strs.length == 1) return strs[0];
        int i = 0;
        while(i < strs[0].length()) {
            for(String s : strs) {
                if(i >=  s.length() || s.charAt(i) != smallestStr.charAt(i)) return  smallestStr.substring(0, i);
            }
            i++;
        }

        return (i == 0) ? "" : smallestStr.substring(0, i);
    }
}