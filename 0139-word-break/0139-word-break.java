class Solution {
     Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];
        Set<String> set = new HashSet<>(wordDict);
        return helper(s,set,0);
    }
    public boolean helper(String s,Set<String> set, int index){
        if (index == s.length()){
            return true;
        }
          if(dp[index] != null)
            return dp[index];

        for(int i=index; i<s.length() ;i++){
            String part = s.substring(index,i+1);
            if(set.contains(part)){
              if(helper(s,set,i+1)){
                dp[index] = true;
                return true;
              }
            }
        }
        dp[index] = false;
        return false;
    }
}