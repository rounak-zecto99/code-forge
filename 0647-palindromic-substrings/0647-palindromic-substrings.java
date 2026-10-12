class Solution {
    public int countSubstrings(String s) {
        char [] ch = s.toCharArray();
        int n = ch.length;

        int ans = 0;

        Boolean [][] dp = new Boolean[n][n];

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(isPall(ch,i,j,dp)){
                    ans++;
                }
            }
        }
        return ans;
    }
    boolean isPall (char [] ch,int start, int end, Boolean [][] dp){
        if(start >= end)
        return  true;

        if(dp[start][end] != null)
        return dp[start][end];

        return dp[start][end] = ch[start++] == ch[end--] && isPall(ch,start,end,dp);
    }

}