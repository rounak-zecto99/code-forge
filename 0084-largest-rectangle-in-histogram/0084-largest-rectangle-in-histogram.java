class Solution {
    int[] stack;
  public void pse(int[] heights, int[] pse) {
    int n = pse.length;
    stack = new int[n];
    int top = -1;

    for (int i = 0; i < n; i++) {
        // Pop while elements on stack are > current element
        while (top >= 0 && heights[stack[top]] > heights[i]) {
            top--;
        }

        // If stack is empty, PSE is -1; otherwise stack[top]
        pse[i] = (top == -1) ? -1 : stack[top];

        // Push current index onto the stack
        stack[++top] = i;
    }
}

public void nse(int[] heights, int[] nse) {
    int n = nse.length;
     stack = new int[n];
    int top = -1; // -1 represents an empty stack

    for (int i = n - 1; i >= 0; i--) {
        // Pop while elements on stack are >= current element
        while (top >= 0 && heights[stack[top]] >= heights[i]) {
            top--;
        }

        // If stack is empty, NSE is heights.length; otherwise stack[top]
        nse[i] = (top == -1) ? n : stack[top];

        // Push current index onto the stack
        stack[++top] = i;
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