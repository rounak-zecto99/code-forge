class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int lastmin = -1;
        int lastmax = -1;
        int lastbad = -1;

        long count = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == minK) {
                lastmin = i;
            } 
            if (nums[i] == maxK) {
                lastmax = i;
            }
            if (nums[i] < minK || nums[i] > maxK) {
                lastbad = i;
                left = lastbad + 1;
            }
            
            if (lastmin != -1 && lastmax != -1) {
                if (left <= Math.min(lastmin, lastmax)) {
                    count += Math.min(lastmin, lastmax) - left + 1;
                }
            }
        }
        return count;
    }
}