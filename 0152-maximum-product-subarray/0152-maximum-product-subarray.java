class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int current = nums[i];

            int newMax = Math.max(
                current,
                Math.max(current * max, current * min)
            );

            int newMin = Math.min(
                current,
                Math.min(current * max, current * min)
            );

            max = newMax;
            min = newMin;

            ans = Math.max(ans, max);
        }

        return ans;
    }
}