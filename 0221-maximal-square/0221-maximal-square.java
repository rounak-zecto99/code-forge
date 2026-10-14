class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] heights = new int[n];
        int max = 0;

        for (int r = 0; r < m; r++) {

            // Update histogram heights for this row
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == '1') {
                    heights[c]++;
                } else {
                    heights[c] = 0;
                }
            }

            // Monotonic stack
            int[] stack = new int[n];
            int top = -1;

            for (int i = 0; i <= n; i++) {
                int cur = (i == n) ? 0 : heights[i];

                while (top != -1 && heights[stack[top]] >= cur) {
                    int height = heights[stack[top--]];
                    int prevSmaller = (top == -1) ? -1 : stack[top];
                    int width = i - prevSmaller - 1;

                    int side = Math.min(height, width);
                    max = Math.max(max, side * side);
                }

                if (i < n) {
                    stack[++top] = i;
                }
            }
        }

        return max;
    }
}