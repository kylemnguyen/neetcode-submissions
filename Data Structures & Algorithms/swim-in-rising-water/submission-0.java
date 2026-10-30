class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        boolean[][] visit = new boolean[N][N];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visit[0][0] = true;

        while(!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int time = current[0];
            int row = current[1];
            int col = current[2];

            if(row == N - 1 && col == N - 1) return time;

            for(int[] dir : directions) {
                int r = dir[0] + row;
                int c = dir[1] + col;

                if(r >= 0 && c >= 0 && r < N && c < N && !visit[r][c]) {
                    visit[r][c] = true;
                    minHeap.offer(new int[]{
                        Math.max(time, grid[r][c]),
                        r,
                        c
                    });
                }
            }
            
        }
        return N * N;
    }
}
