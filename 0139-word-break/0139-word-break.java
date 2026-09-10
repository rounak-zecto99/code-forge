class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean []dp = new Boolean[s.length()+1];
        return helper(wordDict,0,s,dp);
    }
    public boolean helper(List<String> list, int index,String s,Boolean []dp){
        if(index == s.length()){
            return true;
        }
        if(dp[index]!=null)
        return dp[index];
        
        for(int i=index ; i<=s.length(); i++){
            if(list.contains(s.substring(index,i))){
                if(helper(list,i,s,dp)){
                    return dp[index] = true;
                }
            }
        }
        return dp[index]=false;
    }
}