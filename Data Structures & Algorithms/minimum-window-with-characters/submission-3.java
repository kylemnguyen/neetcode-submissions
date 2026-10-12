class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty() || t.length() > s.length()) return "";

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for(char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        int have = 0;
        int need = tMap.size();
        int[] res = {-1, -1};
        int minLength = Integer.MAX_VALUE;
        int left = 0;       
        

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);

            if (tMap.containsKey(ch) && sMap.get(ch).equals(tMap.get(ch))) {
                have++;
            }

            while (have == need) {
                if((r - left + 1) < minLength) {
                    minLength = r - left + 1;
                    res[0] = left;
                    res[1] = r;
                }

                char leftCh = s.charAt(left);
                sMap.put(leftCh, sMap.get(leftCh) - 1);
                if(tMap.containsKey(leftCh) && sMap.get(leftCh) < tMap.get(leftCh)) {
                    have--;
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
