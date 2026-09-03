class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] stack = new int[n];
        int top = -1;

        int maxarea = 0;

        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i];

            while (top != -1 && heights[stack[top]] > currHeight) {
                int index = stack[top--];

                int left = (top == -1) ? -1 : stack[top];

                int area = heights[index] * (i - left - 1);
                maxarea = Math.max(maxarea, area);
            }

            if (i < n) {
                stack[++top] = i;
            }
        }

        return maxarea;
    }
}