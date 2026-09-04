class Solution {
    public int maxProduct(int[] nums) {
        int[]best = {Integer.MIN_VALUE};
       helper(nums,0,best);
       return best[0];
    }
    public int[] helper(int[] nums, int index,int[]best){
        if (index == nums.length - 1) {
            best[0] = nums[index];
       return new int[]{nums[index], nums[index]};
     }
     int [] arr = helper(nums,index+1,best);
     int max = nums[index]*arr[0];
     int min = nums[index]*arr[1];

     int amax = Math.max(max,Math.max(nums[index],min));
     int amin = Math.min(max,Math.min(nums[index],min));
     
     best[0] = Math.max(best[0],amax);
     return new int[]{amax,amin};

    }
}