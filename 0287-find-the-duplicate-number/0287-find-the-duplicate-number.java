class Solution {
       static void swap(int []ar , int s , int e){
        int temp = ar[s];
        ar[s]=ar[e];
        ar[e]=temp;
    }
    public int findDuplicate(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct = nums[i] -1 ;
            if(i!=correct && nums[i]!=nums[correct]){
                swap(nums,i,correct);
            }
            else if(i!=correct && nums[i]==nums[correct]){
                return nums[i];
            }
            else{
                i++;
            }  
        }
        return nums[nums.length-1];
    }
}