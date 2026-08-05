class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int maxseen = nums[0];
        int minseen = nums[nums.length-1];

        int left =-1;
        int right =-1;

        for(int i =0; i<nums.length ; i++){
            maxseen = Math.max(maxseen,nums[i]); //maxseen ka correct index kya hona chahiye

            if(nums[i]<maxseen){
                right = i;
            }
        }
        if(right == -1){
            return 0;
        }
        for(int i = nums.length-1; i>=0 ; i--){
            minseen = Math.min(minseen,nums[i]);

            if(nums[i]>minseen){
                left =i ;
            }
        }

        return right - left +1;
    }
}