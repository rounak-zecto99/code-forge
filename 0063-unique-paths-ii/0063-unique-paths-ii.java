class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length-1;
        int col = obstacleGrid[0].length-1;
        int[][] dp = new int[row+1][col+1];
        for(int []arr : dp){
             Arrays.fill(arr,-1);
        }     
        return helper(row,col, obstacleGrid,dp);
    }
    public int helper( int row,  int col, int[][] obstacleGrid, int[][] dp){
        if(obstacleGrid[row][col] == 1){
            return 0;
        }
        if(row ==0 && col ==0) return 1;

        if(dp[row][col]!= -1) return dp[row][col];
        int ways =0;
        if(row>0){
            ways+=helper(row-1,col, obstacleGrid,dp);
        }
        if(col>0){
            ways+=helper(row,col-1, obstacleGrid,dp);
        }
        dp[row][col] = ways;
        return ways;
    }
}