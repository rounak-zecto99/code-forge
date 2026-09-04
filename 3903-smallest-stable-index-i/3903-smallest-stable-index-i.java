class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int maxSoFar = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);

            int suffixMin = Integer.MAX_VALUE;

            for (int j = i; j < n; j++) {
                suffixMin = Math.min(suffixMin, nums[j]);
            }

            if (maxSoFar - suffixMin <= k) {
                return i;
            }
        }

        return -1;
    }
}