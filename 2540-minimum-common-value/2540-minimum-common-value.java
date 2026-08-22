class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length)
         return getCommon(nums2,nums1);
        
        int ans=-1;

         for(int i=0; i<nums1.length; i++){
         if(binary(nums2,nums1[i])){
            ans = nums1[i];
            break;
         }
         }
         return ans;
    }
    public boolean binary(int []nums, int target){
        int start =0;
        int end = nums.length-1;
        int mid ;
        while(start<=end){
        mid = start+(end-start)/2;

        if(nums[mid] == target){
            return true;
        }
        else if(nums[mid] < target){
            start = mid+1;
        }
        else{
            end = mid -1;
        }
        }
        return false;
    }
}