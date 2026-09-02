// What information changes after every move?
// What choices does a player have?
// What information is needed to describe the next turn?
class Solution {
    public int stoneGameII(int[] piles) {
        int len = piles.length;
        Integer [][] dp = new Integer[len][len];

        int [] suffix = new int[len+1];

        for(int i = len -1; i>=0; i--){
            suffix[i] = piles[i] + suffix[i+1];
        }
        return helper(piles,0,1,suffix,dp);

    }
    public int helper(int[] piles,int curr,int M,int[]suffix,Integer [][] dp){
         if(curr+2*M >= piles.length)
         return suffix[curr];

         if(dp[curr][M]!=null)
         return dp[curr][M];
         
         int best = Integer.MIN_VALUE;
         for(int X=1 ;X<=2*M; X++){
            int opponent = helper(piles,curr+X,Math.max(X,M),suffix,dp);
            int myscore = suffix[curr] -  opponent;
            best = Math.max(best,myscore);
         }
         return dp[curr][M] = best;
    }
}