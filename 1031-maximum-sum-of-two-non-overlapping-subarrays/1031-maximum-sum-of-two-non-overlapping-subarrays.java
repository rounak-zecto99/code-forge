class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(helper(nums,firstLen,secondLen),helper(nums,secondLen,firstLen));
    }
    public int helper(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] dp = new int[n];
        int r = n - 1;
        int sum = 0;

        for (int i = n - 1; i >= n - firstLen; i--) {
            sum += nums[i];
        }
        dp[n - firstLen] = sum;

        for (int i = n - firstLen - 1; i > 0; i--) {

            sum += nums[i];

            if (r - i + 1 > firstLen) {
                sum -= nums[r--];
            }
            dp[i] = Math.max(sum, dp[i + 1]);
        }
        
        sum = 0;
        int left = 0;
        int maxSum = 0;

        for (int i = 0; i < n - firstLen; i++) {
            sum += nums[i];

            if (i - left + 1 > secondLen) {
                sum -= nums[left++];
            }
            maxSum = Math.max(sum + dp[i + 1], maxSum);
        }
        return maxSum;
    }
}