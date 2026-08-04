class Solution {
    public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
    public void sortColors(int[] nums) {
       int left = 0;
       for(int r = 0; r<nums.length; r++){
        if(nums[r]== 0){
            swap(nums,r,left);
            left++;
        }
       }
         for(int r = left; r<nums.length; r++){
            if(nums[r]== 1){
            swap(nums,r,left);
            left++;
        }
       }
       
    }
}