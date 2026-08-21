class Solution {
     public boolean isVal(String s,int left, int right,int[][]pall){
           --right;
           int start = left;
           int end = right;
           if(pall[start][end] !=-1){
            if(pall[start][end] == 0)
            return false;
            
            return true;
           }
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                pall[left][right] = 0;
                pall[start][end] = 0;
            return false;
            }

            left++;
            right--;
        }
        pall[start][end] = 1;
        return true;
    }
    public int minCut(String s) {
        int n= s.length();
        int[][] pall = new int[n][n];
        for(int[]a : pall){
            Arrays.fill(a,-1);
        }
        int[] dp = new int[n];
        
        for(int a=0;a<dp.length;a++){
            dp[a] = -1;
        }
        return helper(s,0,dp,pall);
    }
    public int helper(String s, int index, int[]dp,int[][] pall){
        
        if(index == s.length()){
            return -1;
        }
        if(dp[index] != -1)
        return dp[index];

        int best = 2000;
        for(int i= index; i<s.length(); i++){
            if(isVal(s,index,i+1,pall)){
               int res = 1+helper(s,i+1,dp,pall);
               best = Math.min(best,res);
            }
        }
        dp[index] = best;
        return best;
    }
}