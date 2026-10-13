class Solution {
    public void wiggleSort(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int mid = (nums.length + 1) >> 1;

        int left = mid - 1;
        int right = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                nums[i] = sorted[left--];
            } else {
                nums[i] = sorted[right--];
            }
        }
    }
}