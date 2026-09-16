class Solution {
    public int[] rearrangeArray(int[] nums) {
        int [] array = new int[nums.length];
        int left = 0;
        int right = 1;

        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                array[left] = nums[i];
                left+=2;
            }
            else{
                array[right] = nums[i];
                right+=2;
            }
        }
        return array;
    }
}