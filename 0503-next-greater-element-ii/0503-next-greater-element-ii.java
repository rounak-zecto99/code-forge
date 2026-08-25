class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] stack = new int[n + 1];
        int top = -1;


        int[] ans = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {
            int curr = i % n;
            while (top != -1 && stack[top] <= nums[curr]) {
                top--;
            }

            if (i < n) {
                ans[i] = top == -1 ? -1 : stack[top];
            }
            stack[++top] = nums[curr];
        }
        return ans;
    }
}