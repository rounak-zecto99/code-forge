class Solution {
    public int[] sortedSquares(int[] nums) {
        int [] ans = new int[nums.length];
        int i =0; int k=ans.length-1;
        for(int j=ans.length-1; j>=0 ; j--){
            if(Math.abs(nums[i]) > Math.abs(nums[k])){
                ans[j] = nums[i]*nums[i];
                i++;
            }
            else{
                ans[j] = nums[k]*nums[k];
                k--;
            }
        }
        return ans;
    }
}