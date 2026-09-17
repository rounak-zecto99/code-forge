class Solution {
    public boolean perfectsq(int num1, int num2){
        int y = num1+num2;
        int root = (int)Math.sqrt(y);
        return root*root == y;
    }
    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        boolean []used = new boolean[nums.length];
        return helper(0,0,nums,used);
    }

    public int helper(int lastTaken,int taken,int[] nums, boolean []used){
        if(taken == nums.length){
            return 1;
        }

        int ways = 0;

        for(int i=0; i<nums.length; i++){
            if(used[i])
            continue;

            if(i>0 && nums[i] == nums[i-1] && !used[i-1])
            continue;

            if(taken>0 && !perfectsq(lastTaken,nums[i]))
            continue;

            used[i] = true;

           ways+= helper(nums[i],taken+1,nums,used);

            used[i] = false;
        }
        return ways;
    }
}