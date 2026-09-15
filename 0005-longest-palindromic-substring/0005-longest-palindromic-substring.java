class Solution {
    public boolean isValid(String s, int left, int right, Boolean[][] dp) {
        if (left >= right)
            return true;

        if (dp[left][right] != null)
            return dp[left][right];

        if (s.charAt(left) == s.charAt(right) && isValid(s, left + 1, right - 1, dp)) {
            return dp[left][right] = true;
        }
        return dp[left][right] = false;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0;
        int maxLength = 0;
        Boolean[][] dp = new Boolean[n][n];

        for(int i =0; i<n; i++){
            for(int j=0;j<n; j++){
                if(isValid(s,i,j,dp)){
                    int length = j - i+1;

                    if(length>maxLength){
                        start = i;
                        maxLength = length;
                    }
                }
            }
        }
        return s.substring(start,start+maxLength);        
    }
}