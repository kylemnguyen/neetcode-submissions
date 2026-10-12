class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> count = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        for(int r = 0; r < s.length(); r++) {
            while(count.contains(s.charAt(r))){
                count.remove(s.charAt(left));
                left++;
            }
            count.add(s.charAt(r));
            maxLength = Math.max(maxLength, r - left + 1);
        }        
        return maxLength;
    }
}
