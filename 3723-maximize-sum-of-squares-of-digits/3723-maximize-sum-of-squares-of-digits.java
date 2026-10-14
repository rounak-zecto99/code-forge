class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder ans = new StringBuilder();

        if (sum > num * 9)
            return "";

        while (sum != 0) {
            int i = Math.min(9,sum);
            ans.append(i);
            sum -= i;
            --num;
        }
        for (int i = 0; i < num; i++) {
            ans.append('0');
        }
        return ans.toString();
    }
}