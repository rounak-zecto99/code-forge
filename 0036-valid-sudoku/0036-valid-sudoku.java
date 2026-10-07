class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;

        boolean[][] row = new boolean[n][10];
        boolean[][] col = new boolean[n][10];
        boolean[][][] grid = new boolean[3][3][10];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int curr = board[i][j] - '0';
                if (curr < 0 || curr > 9)
                    continue;

                if (row[i][curr] || col[j][curr] || grid[i / 3][j / 3][curr]) {
                    return false;
                }
                row[i][curr] = true;
                col[j][curr] = true;
                grid[i / 3][j / 3][curr] = true;

            }
        }
        return true;
    }
}