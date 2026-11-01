class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        HashMap<Integer, Integer> fMap = new HashMap<>();
        for(int num : hand) fMap.put(num, fMap.getOrDefault(num, 0) + 1);
        
        for(int num : hand) {
            int start = num;
            while(fMap.getOrDefault(start - 1, 0) > 0) start--;
            while(start <= num) {
                while(fMap.getOrDefault(start, 0) > 0) {
                    for(int i = start; i < start + groupSize; i++) {
                        if(fMap.getOrDefault(i, 0) == 0) return false;
                        fMap.put(i, fMap.get(i) - 1);
                    }
                }
                start++;
            }
        }
        return true;    
    }
}
