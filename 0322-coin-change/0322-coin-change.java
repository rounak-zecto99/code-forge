class Solution {
    static int INF = 1_000_000_000;
    
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int [][]dp = new int[n][amount+1];
        // int ans = helper(coins,amount,n-1);

        // if (ans >= INF) {
        //  return -1;
        // }
        for(int T=0; T<=amount; T++){
            if(T%coins[0] == 0){
                dp[0][T] = T/coins[0];
            }
            else{
                dp[0][T] = INF;
            }
        }

        for(int ind=1; ind<n; ind++){
            for(int T=0; T<=amount; T++){
                int notTake =dp[ind-1][T];
                int take = INF;

                if(coins[ind]<=T)
                take = 1 + dp[ind][T-coins[ind]];

                dp[ind][T] = Math.min(take,notTake);
            }
        }
        int ans = dp[n-1][amount];

        if(ans>=INF){
            return -1;
        }

        return ans;

    }
    // public int helper(int[]coins,int amount,int index){

    //     if(index == 0){
    //         if(amount%coins[0] == 0){
    //             return amount/coins[0];
    //         }
    //         else{
    //             return 1000_000_000;
    //         }
    //     }

    //     int notTake =helper(coins,amount,index-1);
    //     int take = Integer.MAX_VALUE;

    //     if(coins[index]<=amount)
    //     take = 1 + helper(coins,amount-coins[index],index);

    //     return Math.min(take,notTake);
    // }
}