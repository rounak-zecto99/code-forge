class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        long low = 0L, high = 0L;
        int[] ans = new int[2];
        int i = 0;

        for (int a : nums) {
            long bit = 1L << (a % 64);

            if (a < 64) {
                if ((low & bit) != 0) ans[i++] = a;
                else low |= bit;
            } else {
                if ((high & bit) != 0) ans[i++] = a;
                else high |= bit;
            }

            if (i == 2) break;
        }

        return ans;
    }
}