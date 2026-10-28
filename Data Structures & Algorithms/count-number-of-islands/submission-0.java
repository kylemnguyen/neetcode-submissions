class Solution {
    public int numIslands(char[][] grid) {
        
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int islands = 0;

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == '1') {
                    bfs(grid, r, c);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void bfs(char[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        grid[r][c] = '0';
        q.add(new int[]{r, c});
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];

            for(int[] dir : directions) {
                int r_pos = row + dir[0];
                int c_pos = col + dir[1];

                if(r_pos >= 0 && c_pos >= 0 &&
                    r_pos < grid.length && c_pos < grid[0].length && grid[r_pos][c_pos] == '1') {
                        q.add(new int[]{r_pos, c_pos});
                        grid[r_pos][c_pos] = '0';
                    }
            }
        }
    } 
}
