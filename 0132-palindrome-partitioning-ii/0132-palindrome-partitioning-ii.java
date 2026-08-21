class Solution {
    public boolean isVal(String s, int left, int right, int[][] pal) {

        if (left >= right) {
            return true;
        }

        if (pal[left][right] != -1) {
            return pal[left][right] == 1;
        }

        if (s.charAt(left) == s.charAt(right) && isVal(s, left + 1, right - 1, pal)) {
            pal[left][right] = 1;
            return true;
        }

        pal[left][right] = 0;
        return false;
    }

    public int minCut(String s) {
        int n = s.length();
        int[][] pall = new int[n][n];
        for (int[] a : pall) {
            Arrays.fill(a, -1);
        }
        int[] dp = new int[n];

        for (int a = 0; a < dp.length; a++) {
            dp[a] = -1;
        }
        return helper(s, 0, dp, pall);
    }

    public int helper(String s, int index, int[] dp, int[][] pall) {

        if (index == s.length()) {
            return -1;
        }
        if (dp[index] != -1)
            return dp[index];

        int best = 2000;
        for (int i = index; i < s.length(); i++) {
            if (isVal(s, index, i, pall)) {
                int res = 1 + helper(s, i + 1, dp, pall);
                best = Math.min(best, res);
            }
        }
        dp[index] = best;
        return best;
    }
}