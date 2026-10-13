class Solution {
    public long maxAlternatingSum(int[] nums) {

       for(int i=0; i<nums.length; i++){
        nums[i] = Math.abs(nums[i]);
       }
       Arrays.sort(nums);

        long max = 0;
        int left = 0;
        int right = nums.length-1;

        while(left<right){
            max += nums[right]*nums[right--] - nums[left]*nums[left++];
        }
        if((nums.length & 1) == 1)
        max += nums[right]*nums[right];

        return max;

    }
}