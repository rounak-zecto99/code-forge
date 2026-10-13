class Solution {
    public long minTotalTime(int[] forward, int[] backward, int[] queries) {
        int n = forward.length;

        long[] prefix = new long[n + 1];
        long[] suffix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + forward[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + backward[i];
        }
        long distance = 0;
        int start = 0;

        for (int dest : queries) {
            long forwardCost = 0;
            long backwardCost = 0;

            if (dest > start) {
                forwardCost = prefix[dest] - prefix[start];
                backwardCost = suffix[0] - suffix[start + 1] + suffix[dest + 1];
            } else if (dest < start) {
                forwardCost = prefix[n] - prefix[start] + prefix[dest];
                backwardCost = suffix[dest + 1] - suffix[start + 1];
            }
            distance += Math.min(forwardCost, backwardCost);
            start = dest;
        }
        return distance;
    }
}