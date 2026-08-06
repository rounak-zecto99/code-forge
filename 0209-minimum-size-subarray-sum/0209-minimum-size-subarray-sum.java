class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum =0;
        int size=0;
        int back = 0;
        int ans = Integer.MAX_VALUE;
        boolean found = false;
        
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
            size ++; 

            while(sum >= target){
                ans = Math.min(ans, size); 
                found = true;
                sum -= nums[back++];
                size--;
            }

        }
        if(found){
           return ans; 
        }
        return 0;

    }
}