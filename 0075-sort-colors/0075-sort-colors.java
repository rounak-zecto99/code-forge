class Solution {
    public void swap(int [] nums, int left , int right){
               int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
    }
    public void sortColors(int[] nums) {
      int start =0 ;
      int mid  =0;
      int end =nums.length-1;

      while(mid<=end){
        if(nums[mid] == 0){
            swap(nums,start,mid);
            start++;
            mid++;
        }
        else if(nums[mid] == 2){
            swap(nums,end,mid);
            end--;
        }
        else{
            mid++;
        }
      }

            
  }
    }
