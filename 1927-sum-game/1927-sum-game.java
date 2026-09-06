class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int leftQ = 0;
        int rightQ = 0;

        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < n / 2; i++) {
            char ch = num.charAt(i);

            if (ch == '?')
                leftQ++;
            else
                leftSum += ch - '0';
        }

        for (int i = n / 2; i < n; i++) {
            char ch = num.charAt(i);

            if (ch == '?')
                rightQ++;
            else
                rightSum += ch - '0';
        }

        if ((leftQ + rightQ) % 2 == 1)
            return true;

        int difference = leftSum - rightSum;

        return difference != (rightQ - leftQ) * 9 / 2;
    }
}