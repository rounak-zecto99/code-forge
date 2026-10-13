class Solution {
    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void wiggleSort(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            if ((i & 1) == 0) { //even index has to be less
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }
}