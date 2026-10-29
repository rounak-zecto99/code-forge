class Solution {
    int inf = Integer.MAX_VALUE;
    int ninf = Integer.MIN_VALUE;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int n1 = nums1.length;
        int n2 = nums2.length;

        int required = (n1 + n2 + 1) >> 1;

        int start = 0;
        int end = n1;

        int left1;
        int right1;

        int left2;
        int right2;

        while (start <= end) {
            int cut = start + (end - start) / 2;

            int cut2 = required - cut;

            left1 = cut == 0 ? ninf : nums1[cut - 1];
            right1 = cut == n1 ? inf : nums1[cut];

            left2 = cut2 == 0 ? ninf : nums2[cut2 - 1];
            right2 = cut2 == n2 ? inf : nums2[cut2];

            if (left1 > right2) {
                end = cut - 1;
            } else if (left2 > right1) {
                start = cut + 1;
            } else {

                if (((n1 + n2) & 1) == 1) {
                    return Math.max(left1, left2);
                } else {
                    int a = Math.max(left1, left2) + Math.min(right1, right2);

                    return (double) a / 2;
                }
            }
        }
        return 0.0;
    }
}