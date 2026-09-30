class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Ignore non-positive numbers
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        // Mark the existence of 1...n
        for (int i = 0; i < n; i++) {
            int x = Math.abs(nums[i]);

            if (x <= n) {
                nums[x - 1] = -Math.abs(nums[x - 1]);
            }
        }

        // First unmarked index = missing number
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }
}