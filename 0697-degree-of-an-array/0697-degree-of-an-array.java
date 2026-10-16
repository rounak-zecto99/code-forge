class Solution {
    public int findShortestSubArray(int[] nums) {
        int[][] hash = new int[50000][3];

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            hash[n][0]++;

            if (hash[n][1] == 0) {
                hash[n][1] = i + 1;
            }
            hash[n][2] = i + 1;
        }

        int degree = 0;
        int len = Integer.MAX_VALUE;

        for (int[] x : hash) {
            if (x[0] == 0) continue;

            int currLen = x[2] - x[1] + 1;

            if (x[0] > degree) {
                degree = x[0];
                len = currLen;
            } else if (x[0] == degree) {
                len = Math.min(len, currLen);
            }
        }

        return len;
    }
}