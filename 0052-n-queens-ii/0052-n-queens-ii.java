class Solution {
    public int totalNQueens(int n) {
        return helper(n, 0, 0, 0);
    }

    private int helper(int n, int cols, int diag1, int diag2) {
        if (cols == (1 << n) - 1) {
            return 1;
        }

        int available = ((1 << n) - 1) & ~(cols | diag1 | diag2);
        int ways = 0;

        while (available != 0) {
            int bit = available & -available;
            available -= bit;

            ways += helper(
                n,
                cols | bit,
                (diag1 | bit) << 1,
                (diag2 | bit) >> 1
            );
        }

        return ways;
    }
}