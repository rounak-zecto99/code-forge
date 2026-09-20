class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int ones = 0;
        int longest = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i]&1) == 1)
                ones++;

            if (i - left + 1 - ones > k) {
                if ((nums[left++] & 1) == 1)
                    ones--;
            }
            longest = Math.max(i-left+1,longest);
        }
        return longest;
    }
}