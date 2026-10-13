class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);

        long max = 0;
        int left = 0;
        int right = nums.length-1;

        while(left<right){
            max += nums[right--] - nums[left++];
        }
        if((nums.length & 1) == 1)
        max += nums[right];

        return max;
    }
}