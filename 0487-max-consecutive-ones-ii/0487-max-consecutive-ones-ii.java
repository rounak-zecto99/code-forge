class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int zeroCount = 0;
        int best = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            best = Math.max(best, right - left + 1);
        }

        return best;
    }
}