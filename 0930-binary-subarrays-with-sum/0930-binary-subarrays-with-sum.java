class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
     
     return helper(nums,goal) - helper(nums,goal-1) ;
    }
    public int helper(int []nums , int goal){
        if(goal<0)
        return 0;
        int left = 0;
        int count =0;
        int sum =0;

        for(int i=0; i<nums.length; i++){
            sum+=nums[i];

        while(sum>goal){
            sum-=nums[left++];
        }
        count += i-left+1;
        }
        return count;
    }
}