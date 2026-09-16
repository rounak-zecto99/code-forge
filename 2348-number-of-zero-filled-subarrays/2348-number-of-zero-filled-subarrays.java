class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        int last0 = -1;
        // int boundary = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                last0 = -1;
            } else if (last0 == -1) {
                last0 = i;
            }
            // boundary = Math.min(boundary,last0);
            if (last0 >= 0) {
                count += i - last0 + 1;
            }
        }
        return count;
    }
}