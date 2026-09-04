class Solution {
    public int longestSubarray(int[] nums) {
        int freq = 0;
        int left =0;
        int size =0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1)
            freq ++ ;

            if((i-left+1)-freq>1){
                if(nums[left++] == 1)
                freq--;
            }
            size = Math.max(size,i-left);
        }
        return size;
    }
}