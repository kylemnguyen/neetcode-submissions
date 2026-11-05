class Solution {
    public String mergeAlternately(String word1, String word2) {
        int w1 = 0;
        int w2 = 0;
        StringBuilder s = new StringBuilder();
        while(w1 < word1.length() && w2 < word2.length()) {
            s.append(word1.charAt(w1));
            s.append(word2.charAt(w2));
            w1++;
            w2++;
        }

        while(w1 < word1.length()) {
            s.append(word1.charAt(w1));
            w1++;
        }

        while(w2 < word2.length()) {
            s.append(word2.charAt(w2));
            w2++;
        }

        return s.toString();
    }
}