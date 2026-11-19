class Solution {
    public int minimizeSum(int[] nums) {
        int s1 = Integer.MAX_VALUE;
        int s2 = Integer.MAX_VALUE;
        int s3 = Integer.MAX_VALUE;

        int l1 = Integer.MIN_VALUE;
        int l2 = Integer.MIN_VALUE;
        int l3 = Integer.MIN_VALUE;

        for (int num : nums) {

            // 3 smallest
            if (num < s1) {
                s3 = s2;
                s2 = s1;
                s1 = num;
            } else if (num < s2) {
                s3 = s2;
                s2 = num;
            } else if (num < s3) {
                s3 = num;
            }

            // 3 largest
            if (num > l3) {
                l1 = l2;
                l2 = l3;
                l3 = num;
            } else if (num > l2) {
                l1 = l2;
                l2 = num;
            } else if (num > l1) {
                l1 = num;
            }
        }

        return Math.min(
            l3 - s3,
            Math.min(l2 - s2, l1 - s1)
        );
    }
}