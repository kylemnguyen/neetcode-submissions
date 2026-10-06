class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() == 1 && t.length() == 1) {
            return s.charAt(0) == t.charAt(0);
        } else if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for(char ch : s.toCharArray()) {
            if(sMap.containsKey(ch)) {
                sMap.put(ch, sMap.get(ch) + 1);
            } else {
                sMap.put(ch, 1);
            }
        }
        for(char ch : t.toCharArray()) {
            if(tMap.containsKey(ch)) {
                tMap.put(ch, tMap.get(ch) + 1);
            } else {
                tMap.put(ch, 1);
            }
        }

        for(Map.Entry<Character, Integer> entry : tMap.entrySet()) {

            if(!sMap.containsKey(entry.getKey())) {
                return false;
            }
            if(!sMap.get(entry.getKey()).equals(entry.getValue())) {
                return false;
            }

        }

        return true;
    }
}
