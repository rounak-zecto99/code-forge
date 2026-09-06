class Solution {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length())
            return 0;
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return helper(s, t, new StringBuilder(), 0, -1,dp);
    }

    public int helper(String s, String t, StringBuilder sb, int index, int taken,int[][] dp) {

        if (taken != -1 && (sb.charAt(taken) != t.charAt(taken)))
            return 0;

        if (taken == t.length() - 1)
            return 1;

        if (index >= s.length())
            return 0;

        if(taken != -1 && dp[index][taken]!=-1)
        return dp[index][taken];

        int ways = 0;

        char curr = s.charAt(index);
        sb.append(curr);
        ways += helper(s, t, sb, index + 1, taken + 1,dp);
        sb.deleteCharAt(sb.length() - 1);
        ways += helper(s, t, sb, index + 1, taken,dp);

        if(taken>-1)
        dp[index][taken] =ways;

        return  ways;
    }
}