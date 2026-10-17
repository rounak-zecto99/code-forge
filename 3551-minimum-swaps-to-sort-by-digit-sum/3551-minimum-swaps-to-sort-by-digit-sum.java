class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length, c = 0;
        long[] key = new long[n];
        for (int i = 0; i < n; i++) {
            int x = nums[i], s = 0;
            while (x > 0) {
                s += x % 10;
                x /= 10;
            }
            key[i] = ((long) s << 49) | ((long) nums[i] << 17) | i;
        }
        Arrays.sort(key);
        boolean[] visited = new boolean[n];
        int mask = (1 << 17) - 1;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            int curr = i;
            while (!visited[curr]) {
                visited[curr] = true;
                curr = (int) (key[curr] & mask);
            }
            c++;
        }
        return n - c;
    }
}