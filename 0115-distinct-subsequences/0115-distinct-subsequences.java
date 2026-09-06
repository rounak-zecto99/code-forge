class Solution {

    public int numDistinct(String s, String t) {

        if (s.length() < t.length())
            return 0;

        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return helper(s, t, 0, 0, dp);
    }

    public int helper(String s, String t, int index, int taken, int[][] dp) {

        if (taken == t.length())
            return 1;

        if (index == s.length())
            return 0;

        if (dp[index][taken] != -1)
            return dp[index][taken];

        int ways = 0;

        if (s.charAt(index) == t.charAt(taken)) {
            // Take s[index] OR skip it
            ways += helper(s, t, index + 1, taken + 1, dp);
            ways += helper(s, t, index + 1, taken, dp);
        } else {
            // Cannot take s[index], so skip it
            ways += helper(s, t, index + 1, taken, dp);
        }

        return dp[index][taken] = ways;
    }
}

