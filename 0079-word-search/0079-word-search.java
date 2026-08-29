class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        int totalpos = m * n;
        for (int pos = 0; pos < totalpos; pos++) {
            int row = pos / n;
            int col = pos % n;

            if (board[row][col] == word.charAt(0)) {
                if (helper(board, word, 1, row, col, m, n)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, String word, int index, int row, int col, int m, int n) {
        if (index == word.length()) {
            return true;
        }

        char curr = board[row][col];
        board[row][col] = '.';
        char nextword = word.charAt(index);

        if (row > 0 && board[row - 1][col] == nextword) {
            if (helper(board, word, index + 1, row - 1, col, m, n)) {
                return true;
            }
        }
        if (col > 0 && board[row][col - 1] == nextword) {
            if (helper(board, word, index + 1, row, col - 1, m, n)) {
                return true;
            }
        }
        if (row < m - 1 && board[row + 1][col] == nextword) {
            if (helper(board, word, index + 1, row + 1, col, m, n)) {
                return true;
            }
        }
        if (col < n - 1 && board[row][col + 1] == nextword) {
            if (helper(board, word, index + 1, row, col + 1, m, n)) {
                return true;
            }
        }
        board[row][col] = curr;
        return false;
    }
}