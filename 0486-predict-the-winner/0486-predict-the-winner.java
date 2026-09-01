class Solution {
    public boolean predictTheWinner(int[] nums) {
        Integer [][]dp = new Integer[nums.length][nums.length];
        return helper(nums,0,nums.length-1,dp) >=0;
    }
    public int helper(int[] nums,int left, int right,Integer[][]dp){
        if(left == right)
        return nums[left];

        if(dp[left][right]!=null){
            return dp[left][right];
        }

        int leftM = nums[left] - helper(nums,left+1,right,dp);
        int rightM = nums[right] - helper(nums,left,right-1,dp);

        return dp[left][right] = Math.max(leftM,rightM);
    }
}