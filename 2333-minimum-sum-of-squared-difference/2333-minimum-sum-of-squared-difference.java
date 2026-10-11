
import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int max = 0;

        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        long k = (long) k1 + k2;

        long total = 0;
        for (int d : diff) {
            total += d;
        }

        // If we can eliminate every difference
        if (k >= total) {
            return 0;
        }

        int[] freq = new int[max + 1];

        for (int d : diff) {
            freq[d]++;
        }

        // Reduce differences from largest to smallest
        for (int d = max; d > 0 && k > 0; d--) {
            if (freq[d] == 0) {
                continue;
            }

            long count = freq[d];
            long cost = count;

            if (k >= cost) {
                // Reduce every difference d to d - 1
                freq[d - 1] += freq[d];
                k -= cost;
                freq[d] = 0;
            } else {
                // Reduce only k of these differences by 1
                freq[d] -= (int) k;
                freq[d - 1] += (int) k;
                k = 0;
            }
        }

        long ans = 0;

        for (int d = 1; d <= max; d++) {
            ans += (long) d * d * freq[d];
        }

        return ans;
    }
}
