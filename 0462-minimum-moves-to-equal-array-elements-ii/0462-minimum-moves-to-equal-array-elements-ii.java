class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        int median = nums[n>>1];

        // if(n %2 ==0){
        //     median  = (nums[n>>1] + nums[n/2 -1]) >> 1;
        // }

        int req = 0;

        for(int i : nums){
            req += Math.abs( i - median);
        }

        return req;
    }
}