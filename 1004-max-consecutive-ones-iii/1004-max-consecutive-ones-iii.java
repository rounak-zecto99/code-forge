class Solution {
    public int longestOnes(int[] nums, int k) {
        // int [] freq = new int [2];
        int size =0;
        int left =0;
        int maxf =0;

        for(int i=0; i<nums.length ; i++){
            if(nums[i] == 1){
            maxf++;
            }

            if((i-left+1)-maxf>k){
                if(nums[left] == 1){
                  maxf--;
                }
                left++;
            }
            size = Math.max(size,i-left+1);
        }
        return size;
    }
}