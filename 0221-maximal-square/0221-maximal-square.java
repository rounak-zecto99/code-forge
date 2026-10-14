class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] dp = new int[n + 1];
        int max = 0;
        int prev = 0;

        for (int i = 1; i <= m; i++) {
            prev = 0;

            for (int j = 1; j <= n; j++) {
                int temp = dp[j];

                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = 1 + Math.min(
                        prev,
                        Math.min(dp[j - 1], dp[j])
                    );
                    max = Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }

                prev = temp;
            }
        }

        return max * max;
    }
}