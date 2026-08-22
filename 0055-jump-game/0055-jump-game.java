class Solution {
    public boolean canJump(int[] nums) {
 
        Boolean[]dp = new Boolean[nums.length];
               return helper(nums,0,dp);
    }
    public boolean helper(int[] nums, int index, Boolean[]dp){
        if(index >= nums.length-1){
            return true;
        }
        if(dp[index]!=null)
        return dp[index];

        for(int i=index+1; i<=index+nums[index]; i++){

                if(helper(nums,i,dp)){
                    dp[index] = true;
                    return true;
                }

        }
        dp[index] = false;
        return false;
    }
}