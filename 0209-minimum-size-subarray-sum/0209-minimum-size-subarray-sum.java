class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        boolean found = false;
        int left =0;
        int size = nums.length;
        int sum=0;
        for(int r=0; r<nums.length; r++){
            sum+=nums[r];

            while(sum>=target){
                found = true;
                size = Math.min(size,r-left+1);
                sum -= nums[left++];
            }
        }
        if(found)
        return size;

        return 0;
    }
}