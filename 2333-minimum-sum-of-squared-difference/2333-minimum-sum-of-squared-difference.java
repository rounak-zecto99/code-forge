
import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        long k = (long) k1 + k2;
        int left = 0, right = max;

        while (left < right) {
            int mid = left + (right - left) / 2;
            long ops = 0;

            for (int d : diff) {
                if (d > mid) {
                    ops += d - mid;
                }
            }

            if (ops <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int threshold = left;
        long remaining = k;
        long ans = 0;

        for (int d : diff) {
            if (d > threshold) {
                remaining -= d - threshold;
            }
        }

        for(int d : diff){
            long a = Math.min(threshold,d);

            if(remaining > 0 && a == threshold && a > 0){
                a--;
                remaining--;
            }
            ans += a*a;
        }

        return ans;
    }
}
