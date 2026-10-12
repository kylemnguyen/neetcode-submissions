class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }

        int[] s1char = new int[26];
        int[] s2char = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            s1char[s1.charAt(i) - 'a']++;
            s2char[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        int left = 0;
        for(int i = 0; i < 26; i++) {
            if(s1char[i] == s2char[i]) matches++;
        }

        for(int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) return true;
            int pos = s2.charAt(r) - 'a';
            s2char[pos]++;
            if(s2char[pos] == s1char[pos]) {
                matches++;
            } else if (s1char[pos] + 1 == s2char[pos]) {
                matches--;
            }

            pos = s2.charAt(left) - 'a';
            s2char[pos]--;
            if(s1char[pos] == s2char[pos]) {
                matches++;
            } else if (s1char[pos] - 1 == s2char[pos]) {
                matches--;
            }
            left++;
        }

        return matches == 26;
        
    }
}
