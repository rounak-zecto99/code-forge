class Solution {
    void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    }
    public int removeDuplicates(int[] nums) {
        int left = 0;
        for(int right = 1; right<nums.length; right++){
            if(nums[left] != nums[right]){
                swap(nums,++left,right);
            }
        }
        return ++left;
    }
}