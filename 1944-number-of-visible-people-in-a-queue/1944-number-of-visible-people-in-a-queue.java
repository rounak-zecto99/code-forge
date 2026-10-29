class Solution {
    public int[] canSeePersonsCount(int[] heights) {

        int n = heights.length;

        int[] stack = new int[n];
        int top = -1;

        int[] canSee = new int[n];

        stack[++top] = heights[n - 1];

        for (int i = n - 2; i >= 0; i--) {

            if (stack[top] < heights[i]) {
                int rem = 0;

                while (top != -1 && stack[top] < heights[i]) {
                    rem++;
                    top--;
                }
                canSee[i] = top == -1 ? rem: rem+ 1;
            } else {
                canSee[i]++;
            }
            stack[++top] = heights[i];
        }
        return canSee;
    }
}