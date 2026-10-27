class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) >> 1);

            if (mid > 0 && nums[mid - 1] == nums[mid]) { //mid is second occurance
                if ((mid & 1) == 1) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (mid < nums.length - 1 && nums[mid + 1] == nums[mid]) {//mid is first occurance
                if ((mid & 1) == 0) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                return nums[mid];
            }
        }
        return -1;
    }
}