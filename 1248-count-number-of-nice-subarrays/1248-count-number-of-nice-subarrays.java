class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k) - helper(nums,k-1);
    }
    public int helper(int []nums, int k){
        if(k<0)
        return 0;

        int count = 0;
        int left = 0;
        int odd =0;

        for(int i=0; i<nums.length; i++){
            
            if((nums[i]&1) == 1)
            odd++;

            while(odd>k){
                int a = nums[left++];

            if((a&1) == 1){
                odd--;
            }
            }
            count += i-left+1;
        }
        return count;
    }
}