class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder ans = new StringBuilder();

        if (sum > num * 9)
            return "";

        while (sum != 0) {
            for (int i = 9; i >= 0; i--) {
                if (i <= sum) {
                    sum -= i;
                    ans.append(i);
                    --num;
                    break;
                }
            }
        }
        for (int i = 0; i < num; i++) {
            ans.append('0');
        }
        return ans.toString();
    }
}