class Solution {
    public void swap (int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void reverse(int[] arr,int left,int right) {
    // int left = 0;
    // int right = arr.length - 1;

    while (left < right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        left++;
        right--;
    }
}
    public void nextPermutation(int[] nums) {
        int index = -1;

        for(int i=nums.length-2; i>=0; i--){
            if(nums[i+1]>nums[i]){
                index = i;
                break;
            }
        }
          if(index == -1){
            reverse(nums,0, nums.length - 1);
            return;
        }
        for(int j=nums.length-1; j >index; j--){
            if(nums[j]>nums[index]){
               swap(index,j,nums);
                break;
            }
        }
        
        reverse(nums,index+1, nums.length - 1);
    }
   
}