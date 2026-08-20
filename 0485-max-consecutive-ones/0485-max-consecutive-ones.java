class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int size =0;
        int curr =0;
        for(int right=0; right<nums.length; right++){
            if(nums[right] != 0){
            curr++;}
            else{
                curr =0;
            }

            size = Math.max(curr,size);
        }
        return size;
    }
}