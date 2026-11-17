class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int n = nums.size();

        int[] prefix = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums.get(i - 1);
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = l; j <= r; j++) {
                int end = j + i;

                if (end > n) {
                    break;
                }
                int sum = prefix[end] - prefix[i];

                if (sum > 0) {
                    min = Math.min(min, sum);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
