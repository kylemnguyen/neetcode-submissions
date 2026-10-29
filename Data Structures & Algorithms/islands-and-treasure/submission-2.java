
public class Solution {
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int INF = 2147483647;

        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 0) {
                    q.add(new int[]{r, c});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] pos = q.poll();

            for (int[] dir : directions) {
                int row = pos[0] + dir[0];
                int col = pos[1] + dir[1];

                if (row < 0 || col < 0 ||
                    row >= ROWS || col >= COLS ||
                    grid[row][col] != INF) {
                    continue;
                }

                grid[row][col] = grid[pos[0]][pos[1]] + 1;
                q.add(new int[]{row, col});
            }
        }
    }
}
