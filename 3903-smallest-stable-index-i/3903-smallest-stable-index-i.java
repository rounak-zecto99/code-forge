class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int [] suffix = new int[nums.length];
        int minsofar =Integer.MAX_VALUE; 

        for(int i=nums.length-1; i>=0; i--){
            minsofar = Math.min(nums[i],minsofar);
            suffix[i] = minsofar;
        }
        int maxsofar = -1;

        for(int i= 0 ;i<nums.length; i++){
            maxsofar = Math.max(maxsofar,nums[i]);
            int stable = maxsofar - suffix[i];

            if(stable<=k)
            return i;
        }
        return -1;
    }
}