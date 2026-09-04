class Solution {
    int best = Integer.MIN_VALUE;
    public int maxProduct(int[] nums) {
       
       helper(nums,0);
       return best;
    }
    public int[] helper(int[] nums, int index){
        if (index == nums.length - 1) {
            best = Math.max(best, nums[index]);
       return new int[]{nums[index], nums[index]};
     }
     int [] arr = helper(nums,index+1);
     int max = nums[index]*arr[0];
     int min = nums[index]*arr[1];

     int amax = Math.max(max,Math.max(nums[index],min));
     int amin = Math.min(max,Math.min(nums[index],min));
     
     best = Math.max(best,amax);
     return new int[]{amax,amin};

    }
}