class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;

        int[] first = new int[2 * n + 1];

        // -2 means this prefix sum has never been seen
        Arrays.fill(first, -2);

        // prefix sum 0 exists before the array
        first[n] = -1;

        int presum = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {

            if (nums[i] == 1) {
                presum++;
            } else {
                presum--;
            }

            int index = presum + n;

            if (first[index] != -2) {
                maxLength = Math.max(maxLength, i - first[index]);
            } else {
                first[index] = i;
            }
        }

        return maxLength;
    }
}