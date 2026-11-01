class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        int n = hand.length / groupSize;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num : hand){
            if(!freqMap.containsKey(num)) {
                freqMap.put(num, 1);
            } else {
                freqMap.put(num, freqMap.get(num) + 1);
            }
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(freqMap.keySet());

        while(!minHeap.isEmpty()) {
            int first = minHeap.peek();
            for(int i = first; i < first + groupSize; i++) {
                if(!freqMap.containsKey(i)) return false;
                freqMap.put(i, freqMap.get(i) - 1);
                if(freqMap.get(i) <= 0) {
                    if(i != minHeap.peek()) return false;
                    minHeap.poll();
                }
            }
        }
        return true;
        
    }
}
