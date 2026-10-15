
class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            long a = 0L;
            long b = 0L;
            int distinct = 0;

            for (int j = i; j < n; j++) {
                int num = nums.get(j);

                if (num < 62) {
                    long bit = 1L << num;

                    if ((a & bit) == 0) {
                        distinct++;
                    }

                    a |= bit;
                } else {
                    num -= 62;
                    long bit = 1L << num;

                    if ((b & bit) == 0) {
                        distinct++;
                    }

                    b |= bit;
                }

                ans += distinct * distinct;
            }
        }

        return ans;
    }
}
