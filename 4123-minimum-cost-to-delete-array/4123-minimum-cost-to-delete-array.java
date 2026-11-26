class Solution {
    public long minCost(int[] nums) {
        if (nums.length == 3) {
            return nums[0] + nums[nums.length - 1];
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        long sum = 0L;
        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] < 0) {
                count++;
                sum += nums[i];
                max = Math.max(max, nums[i]);
            } else {
                min = Math.min(min, nums[i]);
            }
        }
        long ans = (long) nums[0] + nums[nums.length - 1];
        if (count % 2 == 0) {
            return ans + sum;
        }
        return Math.min(ans + sum - max, ans + sum + min);
    }
}
