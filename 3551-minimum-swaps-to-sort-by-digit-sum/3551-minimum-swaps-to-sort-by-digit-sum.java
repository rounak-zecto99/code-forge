class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        long[] key = new long[n];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            int num = nums[i];

            while (num > 0) {
                sum += num % 10;
                num = num / 10;
            }
            key[i] = ((long) sum << 49) | ((long) nums[i] << 17) | i;
        }
        Arrays.sort(key);

        boolean[] vis = new boolean[n];
        int cycle = 0;
        int mask = (1 << 17) - 1;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                cycle++;

                while (!vis[i]) {
                    vis[i] = true;
                    i = (int) (key[i] & mask);
                }
            }
        }
        return n - cycle;
    }
}