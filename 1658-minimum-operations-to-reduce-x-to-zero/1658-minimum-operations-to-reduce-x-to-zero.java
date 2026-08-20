class Solution {
    public int minOperations(int[] nums, int x) {
        int left =0;
        int size =0;
        int sum =0;
        boolean found = false;
        for(int num: nums){
            sum+=num;
        }
        if(x>sum)
        return -1;
        int target = sum -x;
        sum=0;
        for(int i=0; i<nums.length; i++){
           sum +=nums[i];
           while(sum>target){
           sum -= nums[left++];
           }
           if(sum == target){
            found = true;
            size = Math.max(size,i-left+1);
           }
        }
        if(found){
            return nums.length - size;
        }
        return -1;
    }
}