class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        int[] queens = new int[n];
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];

        helper(list, queens, col, diag1, diag2, 0, n);
        return list;
    }

    public void helper(List<List<String>> list, int[] queens, boolean[] col, boolean[] diag1,
                       boolean[] diag2, int row, int n) {
        if (row == n) {
            List<String> ans = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                StringBuilder a = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == queens[i]) {
                        a.append("Q");
                        continue;
                    }
                    a.append(".");
                }
                ans.add(a.toString());
            }
            list.add(ans);
            return;
        }


        for (int column = 0; column < n; column++) {
            if (col[column] || diag1[row + column] || diag2[row - column + n - 1]) {
                continue;
            }
            col[column] = true;
            diag1[row + column] = true;
            diag2[row - column + queens.length - 1] = true;

            queens[row] = column;

            helper(list, queens, col, diag1, diag2, row+1, n);

            col[column] = false;
            diag1[row + column] = false;
            diag2[row - column + n - 1] = false;
        }
    }

}