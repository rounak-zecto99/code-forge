class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        boolean[] columns = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        int[] queens = new int[n];

        helper(list, columns, diag1, diag2, queens, 0, n);
        return list;
    }

    public void helper(List<List<String>> list, boolean[] columns, boolean[] diag1, boolean[] diag2, int[] queens, int row, int n) {
        if (row == n) {
            List<String> ram = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                StringBuilder a = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == queens[i]) {
                        a.append("Q");
                        continue;
                    }
                    a.append(".");
                }
                ram.add(a.toString());
            }
            list.add(ram);
        }
        for (int col = 0; col < n; col++) {
            if (columns[col] || diag1[row + col] || diag2[row - col + n - 1]) {
                continue;
            }
            columns[col] = true;
            diag1[row + col] = true;
            diag2[row - col + n - 1] = true;

            queens[row] = col;

            helper(list, columns, diag1, diag2, queens, row + 1, n);

            columns[col] = false;
            diag1[row + col] = false;
            diag2[row - col + n - 1] = false;

        }
    }
}