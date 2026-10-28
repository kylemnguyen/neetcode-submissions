class Solution {
    private PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

    public int[][] kClosest(int[][] points, int k) {

        for(int[] point : points) {
            int dist = point[0] * point[0] + point[1] * point[1];
            minHeap.offer(new int[]{dist, point[0], point[1]});
        }

        int[][] ans = new int[k][2];
        for(int i = 0; i < k; ++i) {
            int[] pt = minHeap.poll();
            ans[i] = new int[]{pt[1], pt[2]};
        }

        return ans;

    }
}
