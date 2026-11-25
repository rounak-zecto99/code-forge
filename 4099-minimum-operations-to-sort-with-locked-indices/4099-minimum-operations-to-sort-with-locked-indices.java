class Solution {
    public int minOperations(int[] nums, int[] locked, int k) {
        int n = nums.length;
        boolean[] required = new boolean[n];
        int prefixMax = 0;

        for (int i = 0; i < n - 1; i++) {
            prefixMax = Math.max(prefixMax, nums[i]);

            if (prefixMax > i + 1) {
                required[i] = true;
                required[i + 1] = true;
            }
        }

        int unlockCount = 0;

        for (int i = 0; i < n; i++) {
            if (required[i] && locked[i] == 1) {
                unlockCount++;
            }
        }

        if (unlockCount > k) {
            return -1;
        }

        int[] bit = new int[n + 1];
        int inversionCount = 0;

        for (int i = n - 1; i >= 0; i--) {
            int x = nums[i];

            for (int j = x - 1; j > 0; j -= j & -j) {
                inversionCount += bit[j];
            }

            for (int j = x; j <= n; j += j & -j) {
                bit[j]++;
            }
        }

        return inversionCount + unlockCount;
    }
}