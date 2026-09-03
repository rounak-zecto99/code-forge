class Solution {
    public void pse(int[] heights, int[] pse) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < pse.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                pse[i] = -1;
                stack.push(i);
            } else {
                pse[i] = stack.peek();
                stack.push(i);
            }
        }

    }

    public void nse(int[] heights, int[] nse) {
        Stack<Integer> stack = new Stack<>();

        for (int i = nse.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nse[i] = heights.length;
                stack.push(i);
            } else {
                nse[i] = stack.peek();
                stack.push(i);
            }
        }

    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] pse = new int[n];
        pse(heights, pse);
        int[] nse = new int[n];
        nse(heights, nse);

        int maxarea = 0;

        for (int i = 0; i < heights.length; i++) {
            int previous = i - pse[i] - 1;
            int forward = nse[i] - i;
            int area = heights[i] * (previous + forward);
            maxarea = Math.max(maxarea, area);
        }
        return maxarea;
    }
}