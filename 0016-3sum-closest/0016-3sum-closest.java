class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int currentSum = nums[0]+nums[1]+nums[2];
        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int start = i+1;
            int end = nums.length -1;
             
             while(start<end){
                int newsum = nums[i] + nums[start] + nums[end];

                if(Math.abs(target - newsum) < Math.abs(target - currentSum)){
                    currentSum = newsum;
                }
                if(target>newsum){
                    start ++;
                }
                else if(target<newsum){
                    end --;
                }
                else{
                    currentSum = newsum;
                    return newsum;
                }
             }
        }
        return currentSum;
    }
}