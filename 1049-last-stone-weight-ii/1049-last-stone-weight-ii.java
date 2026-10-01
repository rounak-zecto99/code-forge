class Solution {
    public int lastStoneWeightII(int[] stones) {
        int Tsum = 0;

        for (int x : stones) {
            Tsum += x;
        }
        int k = Tsum >> 1;

        int[][] dp = new int[stones.length][k + 1];

        for (int sum = 0; sum <= k; sum++) {

            // Don't take stones[0]
            dp[0][sum] = sum;

            // Take stones[0]
            if (sum + stones[0] <= k) {
                dp[0][sum] = sum + stones[0];
            }
        }

        for (int index = 1; index < stones.length; index++) {
            for (int sum = 0; sum <= k; sum++) {

                int noTake = dp[index - 1][sum];

                int take = sum;
                if (sum + stones[index] <= k) {
                    take = dp[index - 1][sum + stones[index]];
                }

                dp[index][sum] = Math.max(take, noTake);
            }
        }
            int val = dp[stones.length -1 ][0];

    return Tsum-(val<<1);
    }
}

    // public int helper(int[] stones, int index, int sum, int[][] dp) {

    //     if (sum == k)
    //         return sum;

    //     if (index < 0)
    //         return sum;

    //     if (dp[index][sum] != -1)
    //         return dp[index][sum];

    //     int take = sum;
    //     if (sum + stones[index] <= k)
    //         take = helper(stones, index - 1, sum + stones[index], dp);

    //     int NoTake = helper(stones, index - 1, sum, dp);

    //     return dp[index][sum] = Math.max(take, NoTake);
    // }
