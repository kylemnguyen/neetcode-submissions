class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        // Character : Freq in our string
        
        int maxFreq = 0;
        int left = 0;
        int ans = 0;

        for(int r = 0; r < s.length(); r++) {

            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, count.get(s.charAt(r)));

            while((r - left - maxFreq + 1) > k) {
                count.put(s.charAt(left), count.get(s.charAt(left)) - 1);
                left++;
            }

            ans = Math.max(ans, r - left + 1);

        }

        return ans;
    }
}
