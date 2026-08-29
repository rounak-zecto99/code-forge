class Solution {
    public void solveSudoku(char[][] board) {
        int n = 9;
        boolean[][] rows = new boolean[n][n + 1];
        boolean[][] columns = new boolean[n][n + 1];
        boolean[][][] grid = new boolean[3][3][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int curr = board[i][j] - '0';
                if (curr > 0 && curr < 10) {
                    rows[i][curr] = true;
                    columns[j][curr] = true;
                    grid[i / 3][j / 3][curr] = true;
                }
            }
        }
        helper(board, rows, columns, grid, 0);
    }

    public boolean helper(char[][] board, boolean[][] rows, boolean[][] columns, boolean[][][] grid, int pos) {
        if (pos == 81) {
            return true;
        }
        int row = pos / 9;
        int col = pos % 9;

        if (board[row][col] != '.')  return helper(board, rows, columns, grid, pos + 1);
        for (int i = 1; i <= 9; i++) {
            int curr = i;
            if (rows[row][curr] || columns[col][curr] || grid[row / 3][col / 3][curr]) {
                continue;
            }
            rows[row][curr] = true;
            columns[col][curr] = true;
            grid[row / 3][col / 3][curr] = true;


            board[row][col] = (char) (curr + '0');
            if (helper(board, rows, columns, grid, pos + 1)) {
                return true;
            }
            board[row][col] = '.';

            rows[row][curr] = false;
            columns[col][curr] = false;
            grid[row / 3][col / 3][curr] = false;
        }
        return false;
    }
}

