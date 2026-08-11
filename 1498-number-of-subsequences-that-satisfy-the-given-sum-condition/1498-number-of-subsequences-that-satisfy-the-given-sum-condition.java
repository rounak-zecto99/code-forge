class Solution {
    static int MOD = 100_0000_007;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        long [] pow = new long[nums.length];
        pow[0]=1;
        for(int i=1;i<pow.length;i++){
           pow[i]=(2*pow[i-1])%MOD;
        }
         int start = 0;
         int end = nums.length-1;
       long count = 0;
         while(start<=end){
            if(nums[start]+nums[end]<=target){
                    count = (count+ pow[end-start])%MOD;
                    start++;
            }
            else{
                end--;
            }
         }
         return(int) count;
    }
}