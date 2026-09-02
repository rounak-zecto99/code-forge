class Solution {
private int[][] dp;

public int stoneGameII(int[] piles) {
    int n = piles.length;

    // suffix[i] = total stones from i to n - 1
    int[] suffix = new int[n + 1];

    for (int i = n - 1; i >= 0; i--) {
        suffix[i] = piles[i] + suffix[i + 1];
    }

    dp = new int[n][n + 1];

    return helper(0, 1, piles, suffix);
}

private int helper(int curr, int M, int[] piles, int[] suffix) {

    // Current player can take everything remaining
    if (curr + 2 * M >= piles.length) {
        return suffix[curr];
    }

    if (dp[curr][M] != 0) {
        return dp[curr][M];
    }

    int maxScore = 0;

    // X = number of piles taken
    for (int X = 1; X <= 2 * M; X++) {

        int opponentScore =
            helper(curr + X, Math.max(M, X), piles, suffix);

        int myScore = suffix[curr] - opponentScore;

        maxScore = Math.max(maxScore, myScore);
    }

    return dp[curr][M] = maxScore;
}

}
