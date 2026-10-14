class Solution {
    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = (matrix[0][i] - '0');
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[j][i] == '1') {
                    dp[j][i] = (matrix[j][i] - '0') + dp[j - 1][i];
                }
            }
        }

        // System.out.println(Arrays.deepToString(dp));
        int max = 0;

        for (int[] arr : dp) {
            int[] stack = new int[n];
            int top = -1;

            for (int i = 0; i <= n; i++) {
                int cur = i == n ? 0 : arr[i];

                while (top != -1 && arr[stack[top]] >= cur) {
                    int num = arr[stack[top--]];
                    int back = (top == -1) ? -1 : stack[top];
                    if ((i - back - 1) >= num) {
                        int area = num * num;
                        max = Math.max(max, area);
                    }
                }
                stack[++top] = i;
            }
        }
        return max;
    }
}
// [[1, 0, 0, 1, 1, 0, 1, 1], 
// [2, 0, 0, 0, 0, 1, 0, 0], 
// [0, 1, 1, 1, 0, 0, 1, 1], 
// [0, 0, 0, 2, 0, 0, 0, 2], 
// [0, 0, 0, 0, 0, 1, 1, 3], 
// [1, 1, 1, 1, 1, 2, 2, 4], 
// [2, 0, 0, 2, 0, 3, 3, 0], 
// [0, 1, 1, 0, 1, 4, 4, 0]]