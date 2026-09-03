//either can skip once or twice but problem is in start where they can skip only once
class Solution {
    public int rob(int[] nums) {
        int index = nums.length-1;
        int [] dp = new int[index+1];
        Arrays.fill(dp,-1);

        return helper(nums,index,dp);
    }
    public int helper(int[] nums, int index,int[]dp){
        if(index<0){
            return 0;
        }
        if(index == 0){
            return nums[0];
        }
        if(dp[index]!=-1)
        return dp[index];
        
        int skip1 = nums[index] + helper(nums,index-2,dp);
        
        int skip2 = nums[index-1] + helper(nums,index-3,dp);
        

        return dp[index] = Math.max(skip1,skip2);
    }
}