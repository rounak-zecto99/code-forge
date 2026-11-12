class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int flag = -1;
        int best = 1;
        int curLen = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                if (flag == -1 || flag == 1) {
                    curLen++;
                } else {
                    curLen = 2;
                }
                flag = 1;
            } else if (nums[i - 1] > nums[i]) {
                if (flag == -1 || flag == 2) {
                    curLen++;
                } else {
                    curLen = 2;
                }
                flag = 2;
            } else {
                curLen = 1;
                flag = -1;
            }
            best = Math.max(best, curLen);

        }
        return best;
    }
}