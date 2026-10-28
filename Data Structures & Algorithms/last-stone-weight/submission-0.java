class Solution {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) {
            return stones[0];
        }

        for(int stone : stones) {
            minHeap.add(-stone);
        }

        while(minHeap.size() > 1) {

            int stone1 = minHeap.poll();
            int stone2 = minHeap.poll();

            int remainder = stone1 - stone2;
            if(remainder != 0) minHeap.offer(remainder);

        }

        return (minHeap.peek() != null) ? Math.abs(minHeap.poll()) : 0;
    }


}
