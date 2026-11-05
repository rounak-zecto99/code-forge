class Solution {
    int [][] dp;

    public int maxProfit(int[] prices) {
        dp = new int[prices.length][3];

        for(int []ar : dp)
        Arrays.fill(ar,-1);
        
        return helper(prices,0, -1);
    }

    public int helper(int[] prices, int index, int action){
        if(index == prices.length - 1){
            return action == -1 ? 0 : prices[index];
        }
        if(dp[index][action + 1] != -1)
        return dp[index][action + 1];

        int take = prices[index] * action + helper(prices,index+1,action*-1);

        int NoTake = helper(prices,index+1,action);

        return dp[index][action + 1] = Math.max(take, NoTake);
    }
}