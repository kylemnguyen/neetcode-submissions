class Solution {
    
    private int ROWS;
    private int COLS;
    private Set<Pair<Integer, Integer>> path;
    
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        path = new HashSet<>();

        for(int row = 0; row < ROWS; row++) {
            for(int col = 0; col < COLS; col++) {
                if (dfs(row, col, 0, word, board)) return true;
            }
        }

        return false;
    }

    private boolean dfs(int r, int c, int i, String word, char[][] board) {
        if( i == word.length() ) return true;
        Pair<Integer, Integer> pair = new Pair<>(r, c);
        // check validity
        if( r < 0 || c < 0 || r >= ROWS || c >= COLS  ||
            path.contains(pair) || board[r][c] != word.charAt(i) ) {
                return false;
            }

        path.add(pair);
        boolean ans = (
            dfs(r + 1, c, i + 1, word, board) ||
            dfs(r - 1, c, i + 1, word, board) ||
            dfs(r, c + 1, i + 1, word, board) ||
            dfs(r, c - 1, i + 1, word, board)
        );
        path.remove(pair);

        return ans;
    }
}
