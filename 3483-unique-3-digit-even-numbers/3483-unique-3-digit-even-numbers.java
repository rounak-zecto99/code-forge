class Solution {
    public int totalNumbers(int[] digits) {
        Arrays.sort(digits);

        int n = digits.length;
        Integer[][] dp = new Integer[1 << n][4];

        return helper(digits, 0, 0, dp);
    }

    private int helper(int[] digits, int mask, int len, Integer[][] dp) {

        if (len == 3)
            return 1;

        if (dp[mask][len] != null)
            return dp[mask][len];

        int count = 0;

        for (int i = 0; i < digits.length; i++) {

            // already used
            if ((mask & (1 << i)) != 0)
                continue;

            // leading zero
            if (len == 0 && digits[i] == 0)
                continue;

            // third digit must be even
            if (len == 2 && digits[i] % 2 != 0)
                continue;

            // duplicate handling
            if (i > 0 &&
                digits[i] == digits[i - 1] &&
                (mask & (1 << (i - 1))) == 0)
                continue;

            count += helper(
                digits,
                mask | (1 << i),
                len + 1,
                dp
            );
        }

        return dp[mask][len] = count;
    }
}