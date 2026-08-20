class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int size =0;

        for(int right=0; right<nums.length; right++){
            if(nums[right] == 0)
            left = right +1;

            size = Math.max(size,right-left+1);
        }
        return size;
    }
}