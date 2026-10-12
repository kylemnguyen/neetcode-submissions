class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }

        int[] s1char = new int[26];
        int[] s2char = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            s1char[s1.charAt(i) - 'a'] = s1char[s1.charAt(i) - 'a'] + 1;
            s2char[s2.charAt(i) - 'a'] = s2char[s2.charAt(i) - 'a'] + 1;
        }
        int matches = 0;
        for(int i = 0; i < 26; i++) {
            if(s1char[i] == s2char[i]) matches++;
        }
        if(matches == 26) return true;

        for(int r = s1.length(); r < s2.length(); r++) {
            matches = 0;
            int left = r - s1.length();            
            s2char[s2.charAt(r) - 'a'] = s2char[s2.charAt(r) - 'a'] + 1;
            s2char[s2.charAt(left) - 'a'] = s2char[s2.charAt(left) - 'a'] - 1;

            for(int i = 0; i < 26; i++) {
                if(s1char[i] == s2char[i]) matches++;
            }
            if (matches == 26) return true;
        }

        return false;
        
    }
}
