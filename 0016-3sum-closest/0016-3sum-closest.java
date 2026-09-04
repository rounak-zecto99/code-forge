class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int currsum = nums[0]+nums[1]+nums[2];
        for(int i=0; i<nums.length-2; i++){
            int start = i+1;
            int end = nums.length-1;

            while(start<end){
                int newsum = nums[i]+nums[start]+nums[end];

                if(Math.abs(target-newsum)<Math.abs(target-currsum)){
                    currsum = newsum;
                }
                if(newsum<target){
                    start++;
                }
                else if(newsum>target){
                    end --;
                }
                else{
                    return newsum;
                }
            }
        }
        return currsum;
    }
}