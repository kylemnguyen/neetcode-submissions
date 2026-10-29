class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int time = 0; 

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == 2) {
                    q.add(new int[]{r, c});
                } 
                if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }


        while(fresh > 0 && !q.isEmpty()) {
            int length = q.size();
            for(int i = 0; i < length; i++) {
                int[] pos = q.poll();

                for(int[] dir : directions) {
                    int row = pos[0] + dir[0];
                    int col = pos[1] + dir[1];

                    if( row >= 0 && col >= 0 &&
                        row < ROWS && col < COLS &&
                        grid[row][col] == 1) {
                            grid[row][col] = 2;
                            q.add(new int[]{row, col});
                            fresh--;
                        }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
