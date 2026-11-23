class Solution {
    public int minimumK(int[] nums) {
        int start = 1; 
        int end = 100_000;

        while(start < end){
            int mid = start + ((end - start) >> 1);

            if(!nonPositive(nums,mid)){
                start = mid + 1;
            }
            else{
                end = mid;
            }

        }
        return end;
    }
    boolean nonPositive(int []nums,int k){
        long operations = 0;

        for( int num : nums){
            operations += (num + k - 1) / k;
        }

        return operations <= 1L * k* k;

    }
}