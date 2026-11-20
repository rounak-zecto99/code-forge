class Solution {
    public int minSubarray(int[] nums, int p) {

        int n = nums.length;
        int total = 0;

        for (int num : nums) {
            total = (total + num) % p;
        }

        int target = total;

        if (target == 0)
            return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefix = 0;
        int ans = n;

        for (int i = 0; i < n; i++) {

            prefix = (prefix + nums[i]) % p;

            int needed = (prefix - target + p) % p;

            if (map.containsKey(needed)) {
                ans = Math.min(ans, i - map.get(needed));
            }

            // Store the latest index for this remainder
            map.put(prefix, i);
        }

        return ans == n ? -1 : ans;
    }
}
