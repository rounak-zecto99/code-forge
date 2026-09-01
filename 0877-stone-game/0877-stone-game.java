class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;

        if((n&1) == 0)
        return true;

        Integer[][] dp = new Integer[n][n];

        int res = helper(piles, 0, n - 1, dp);

        if (res > 0)
            return true;

        return false;

    }

    public int helper(int[] piles, int left, int right, Integer[][] dp) {
        if (left == right)
            return piles[left];

        if (dp[left][right] != null)
            return dp[left][right];

        int choice1 = piles[left] - helper(piles, left + 1, right, dp);
        int choice2 = piles[right] - helper(piles, left, right - 1, dp);

        return dp[left][right] = Math.max(choice1, choice2);
    }
}