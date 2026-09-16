class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int counter =1;
        for(int i =1; i< nums.length ;i++){
             if(counter == 0){
                majority = nums[i];
            }
            if(nums[i] == majority){
                counter++;
            }
            else{
                counter--;
            }
           
        }
        return majority;
    }
}