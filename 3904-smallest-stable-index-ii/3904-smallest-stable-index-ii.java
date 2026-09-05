class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int [] suffix = new int[nums.length];
        int minsofar = Integer.MAX_VALUE;
        for(int i=n-1;i>=0; i--){
            suffix[i] = Math.min(minsofar,nums[i]);
            minsofar = suffix[i];
        }
        // System.out.println(Arrays.toString(suffix));
        int maxsofar = -1;

        for(int j=0; j<nums.length ; j++){
           maxsofar = Math.max(nums[j],maxsofar);
           if(maxsofar-suffix[j]<=k)
            return j;
        }
        return -1;
    }
}