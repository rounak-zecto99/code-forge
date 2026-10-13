class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        int lower = 100;

        while (start <= end) {
            int mid = start + ((end - start) >> 1);

            if (nums[mid] >= target) {
                if (nums[mid] == target) {
                    lower = mid;
                }
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return lower + (nums.length >> 1) < nums.length && nums[lower + (nums.length >> 1)] == target;
    }
}