class Solution {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        // similar to # of islands, I believe we can do a bfs
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int maxArea = 0;

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == 1) {
                    int area = bfs(grid, r, c);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    public int bfs(int[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        int area = 0;
        // if(grid[r][c] == 1) {
        grid[r][c] = 0;
        q.offer(new int[]{r, c});
        area++;
        // }

        while(!q.isEmpty()) {
            int[] pos = q.poll();

            for(int[] dir : directions) {
                int r_pos = pos[0] + dir[0];
                int c_pos = pos[1] + dir[1];

                if(r_pos >= 0 && c_pos >= 0 &&
                    r_pos < grid.length && c_pos < grid[0].length && grid[r_pos][c_pos] == 1) {
                        q.offer(new int[]{r_pos, c_pos});
                        grid[r_pos][c_pos] = 0;
                        area++;
                    }


            } 


        }

        return area;
    }
}
