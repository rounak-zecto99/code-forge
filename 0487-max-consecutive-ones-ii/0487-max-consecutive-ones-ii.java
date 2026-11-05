class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int zeroIndex = -1;
        int best = 0;
        int freq = 0;
        int left = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                freq++;

                if(freq > 1){
                    left = zeroIndex + 1;
                    freq--;
                }
                    zeroIndex = i;
            }
            best = Math.max(best, i - left + 1);
        }
        return best;
    }
}