class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 1;
        int end = nums.length;
        boolean found;
        int ans = 0;
        while(start<=end){
            found = false;
            int len = start+(end-start)/2;
            int sum = 0;
            for(int i =0;i<nums.length;i++){
                sum += nums[i];
                if(i>=len){
                    sum -= nums[i-len];
                }
                if(i>=len-1 && sum >= target){
                  found = true;
                  break;
                }
            }
            if(found){
                ans = len;
                end = len - 1;
            }
            else{
                start = len +1;
            }
        }
        return ans;
    }
}