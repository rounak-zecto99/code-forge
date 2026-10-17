class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] stack = new int[n];
        int top = -1;

        int two = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {

            if(nums[i] < two)
            return true;

            while(top != -1 && stack[top] < nums[i]){
                two = stack[top--];
            }
            stack[++top] = nums[i];
        }

        return false;
    }
}