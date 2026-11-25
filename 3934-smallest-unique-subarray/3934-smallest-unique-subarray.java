class Solution {

    public int smallestUniqueSubarray(int[] nums) {
        final long modulus = 1000000007L;
        final long base = 911382323L;

        int n = nums.length;

        long[] prefixHash = new long[n + 1];
        long[] basePowers = new long[n + 1];

        basePowers[0] = 1;

        // Precompute prefix hashes and powers of base
        for (int i = 0; i < n; i++) {
            prefixHash[i + 1] =
                (prefixHash[i] * base + nums[i]) % modulus;

            basePowers[i + 1] =
                (basePowers[i] * base) % modulus;
        }

        int leftLength = 1;
        int rightLength = n;

        while (leftLength < rightLength) {
            int mid = leftLength + (rightLength - leftLength) / 2;

            if (hasUniqueWindow(mid, n, prefixHash, basePowers, modulus)) {
                rightLength = mid;
            } else {
                leftLength = mid + 1;
            }
        }

        return leftLength;
    }

    private boolean hasUniqueWindow(
        int len,
        int n,
        long[] prefixHash,
        long[] basePowers,
        long modulus
    ) {
        Map<Long, Integer> windowFrequency = new HashMap<>();

        for (int start = 0; start + len <= n; start++) {
            int end = start + len;

            long windowHash =(prefixHash[end] - (prefixHash[start] * basePowers[len]) % modulus + modulus) % modulus;

            windowFrequency.merge(windowHash, 1, Integer::sum);
        }

        for (int frequency : windowFrequency.values()) {
            if (frequency == 1) {
                return true;
            }
        }

        return false;
    }
}