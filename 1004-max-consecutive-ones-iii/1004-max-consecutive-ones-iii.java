class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeros = 0;

        for (int right = 0; right < nums.length; right++) {
            zeros += (nums[right] ^ 1);

            if (zeros > k) {
                zeros -= (nums[left] ^ 1);
                left++;
            }
        }

        return nums.length - left;
    }
}