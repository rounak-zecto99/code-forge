class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int n = nums.size();

        int[] prefix = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums.get(i - 1);
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        int ans = Integer.MAX_VALUE;

        for (int end = l; end <= n; end++) {

            // Add the newly eligible starting index
            int add = prefix[end - l];
            map.merge(add, 1, Integer::sum);

            // Remove the starting index that is now too far away
            int removeIndex = end - r - 1;

            if (removeIndex >= 0) {
                int val = prefix[removeIndex];

                if (map.get(val) == 1) {
                    map.remove(val);
                } else {
                    map.put(val, map.get(val) - 1);
                }
            }

            // Largest prefix sum strictly smaller than prefix[end]
            Integer best = map.lowerKey(prefix[end]);

            if (best != null) {
                ans = Math.min(ans, prefix[end] - best);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
