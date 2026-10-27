
class Solution {
    Boolean[][] dp;

    public boolean isInterleave(String s, String t, String s3) {
        int lenS = s.length();
        int lenT = t.length();
        int len = s3.length();

        if (lenS + lenT != len)
            return false;

        dp = new Boolean[lenS + 1][lenT + 1];

        return helper(s, t, s3, 0, 0);
    }

    boolean helper(String s, String t, String s3, int j, int k) {
        if (j == s.length() && k == t.length())
            return true;

        if (dp[j][k] != null)
            return dp[j][k];

        int i = j + k;
        char cur = s3.charAt(i);

        boolean ans = false;

        if (j < s.length() && s.charAt(j) == cur
                && helper(s, t, s3, j + 1, k)) {
            ans = true;
        }

        if (!ans && k < t.length() && t.charAt(k) == cur
                && helper(s, t, s3, j, k + 1)) {
            ans = true;
        }

        return dp[j][k] = ans;
    }
}
