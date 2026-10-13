class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        k = k % n;

        int[][] shifted = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    // Even row: shift left by k
                    shifted[i][j] = mat[i][(j + k) % n];
                } else {
                    // Odd row: shift right by k
                    shifted[i][j] = mat[i][(j - k + n) % n];
                }
            }
        }

        // Compare shifted matrix with original
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (shifted[i][j] != mat[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}