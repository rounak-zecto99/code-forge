class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x : nums){
            sum += x;
        }
        if((sum&1) == 1)
        return false;

        int target = sum>>1;

        Boolean [][] dp = new Boolean[nums.length][target+1];
        return helper(nums,target,nums.length-1,dp);
    }
    boolean helper(int []arr, int sum, int index,Boolean [][] dp){
        
        if(sum == 0)
        return true;
        
        if(sum < 0 || index < 0)
        return false;
        
        if(dp[index][sum]!=null)
        return dp[index][sum];
        
        if(helper(arr, sum-arr[index], index-1,dp)){
            return dp[index][sum] = true;
        }
        if(helper(arr, sum, index-1,dp)){
            return dp[index][sum] = true;
        }
        return dp[index][sum] = false;
    }

}