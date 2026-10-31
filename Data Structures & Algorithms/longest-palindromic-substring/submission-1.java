class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int ansLen = 0;

        for(int i = 0; i < s.length(); i++) {
            int left = i - 1;
            int right = i + 1;

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if(ansLen < (right - left + 1)) {
                    ansLen = right - left + 1;
                    ans = s.substring(left, right + 1);
                }
                left--;
                right++;
            }

            left = i;
            right = i +1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if(ansLen < (right - left + 1)) {
                    ansLen = right - left + 1;
                    ans = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        return (ans == "") ? s.substring(0, 1): ans;    
    }
}
