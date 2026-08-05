class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0 || k ==1){
            return 0 ;
        }
        int product =1;
        int total = 0;
        int back =0;

        for(int i= 0; i<nums.length; i++){
            product *= nums[i];

            while(product>=k){
                product /= nums[back];
                back++;
            }
            total += i - back + 1;
        }
        return total;
    }
}