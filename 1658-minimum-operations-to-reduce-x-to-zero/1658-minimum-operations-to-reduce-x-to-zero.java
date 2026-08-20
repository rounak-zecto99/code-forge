class Solution {
    public int minOperations(int[] nums, int x) {

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        if (x > total) {
            return -1;
        }

        int target = total - x;

        int left = 0;
        int windowSum = 0;
        int maxLen = -1;

        for (int right = 0; right < nums.length; right++) {

            windowSum += nums[right];

            while (windowSum > target) {
                windowSum -= nums[left++];
            }

            if (windowSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}