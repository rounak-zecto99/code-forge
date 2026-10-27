
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = start + ((end - start) >> 1);

            // Make mid even using XOR
            mid ^= (mid & 1);

            if (nums[mid] == nums[mid + 1]) {
                start = mid + 2;
            } else {
                end = mid;
            }
        }

        return nums[start];
    }
}
