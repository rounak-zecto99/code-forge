// farthest → farthest index you can reach
// currentEnd → boundary of the current jump
// jumps → number of jumps taken
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n];
        for(int a=0; a<dp.length ;a++){
            dp[a] = -1;
        }
        return helper(nums,0,dp);
    }
    public int helper(int[] nums, int index, int []dp){
        if(index >= nums.length-1){
            return 0;
        }
        if(dp[index]!=-1)
        return dp[index];

        int best = Integer.MAX_VALUE;

        for(int i= index+1;i<=index+nums[index];i++){
       int result = helper(nums, i, dp);

           if (result != Integer.MAX_VALUE) {
           result = 1 + result;
           best = Math.min(best, result);
            }
        }
        dp[index]= best;
        return best;
    }
}