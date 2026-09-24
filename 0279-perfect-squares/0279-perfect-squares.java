class Solution {
    static int[] squares;
    static int INF = 1000_000_000;
    static {
        squares = new int[100];

        for (int i = 1; i <= 100; i++) {
            squares[i - 1] = i * i;
        }
    }

    public int numSquares(int n) {
        int[][]dp = new int[100][n+1];

        for(int [] ar:dp){
        Arrays.fill(ar,-1);
        }

        int ans = helper(n,99,dp);

        if(ans == Integer.MAX_VALUE)
        return -1;

        return ans;
    }

    public int helper(int n,int index, int[][] dp) {
        if(index == 0){
            if(n%squares[0] == 0){
                return n/squares[0];
            }
            else{
                return INF;
            }
        }
        if(dp[index][n] != -1)
        return dp[index][n];

        int notTake = helper(n,index-1,dp);
        int Take = INF;

        if(squares[index]<=n){
            Take = 1+helper(n-squares[index],index,dp);
        }
        return dp[index][n] = Math.min(notTake,Take);
    }
}