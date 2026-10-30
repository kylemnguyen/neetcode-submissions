class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        int ans = 0;
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for(int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.computeIfAbsent(i, key -> new ArrayList<>()).add(new int[]{dist, j});
                adj.computeIfAbsent(j, key -> new ArrayList<>()).add(new int[]{dist, i});
            }
        }

        minHeap.offer(new int[]{0, 0});

        while(visited.size() < n) {
            int[] curr = minHeap.poll();
            int dist = curr[0];
            int i = curr[1];

            if(visited.contains(i)) continue;

            ans += dist;
            visited.add(i);
            
            for(int[] nei : adj.getOrDefault(i, Collections.emptyList())) {
                int neiDist = nei[0];
                int neiIndex = nei[1];
                if(!visited.contains(neiIndex)) minHeap.offer(new int[]{neiDist, neiIndex});
            }
        }

        return ans;
    }
}
