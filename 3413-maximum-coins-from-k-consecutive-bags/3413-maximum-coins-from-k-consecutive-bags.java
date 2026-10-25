
import java.util.*;

class Solution {
    public long maximumCoins(int[][] coins, int k) {
        Arrays.sort(coins, (a, b) -> Integer.compare(a[0], b[0]));

        int n = coins.length;
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            long length = (long) coins[i][1] - coins[i][0] + 1;
            prefix[i + 1] = prefix[i] + length * coins[i][2];
        }

        long ans = 0;

        for (int[] seg : coins) {
            long leftStart = seg[0];
            long rightStart = (long) seg[1] - k + 1;

            ans = Math.max(ans, getCoins(coins, prefix,
                    leftStart, leftStart + k - 1));

            ans = Math.max(ans, getCoins(coins, prefix,
                    rightStart, rightStart + k - 1));
        }

        return ans;
    }

    private long getCoins(int[][] coins, long[] prefix,
                          long L, long R) {
        int n = coins.length;

        // First segment whose end >= L
        int i = 0, high = n;
        while (i < high) {
            int mid = i + (high - i) / 2;
            if (coins[mid][1] < L) {
                i = mid + 1;
            } else {
                high = mid;
            }
        }
        int first = i;

        // First segment whose start > R
        i = 0;
        high = n;
        while (i < high) {
            int mid = i + (high - i) / 2;
            if (coins[mid][0] <= R) {
                i = mid + 1;
            } else {
                high = mid;
            }
        }
        int last = i - 1;

        if (first > last || first == n || last < 0) {
            return 0;
        }

        if (first == last) {
            long left = Math.max(L, (long) coins[first][0]);
            long right = Math.min(R, (long) coins[first][1]);

            if (left > right) return 0;

            return (right - left + 1) * coins[first][2];
        }

        // Assume all segments from first through last are complete.
        long total = prefix[last + 1] - prefix[first];

        // Correct the first segment for partial coverage.
        long firstFull =
                ((long) coins[first][1] - coins[first][0] + 1)
                * coins[first][2];

        long firstPart =
                ((long) coins[first][1]
                - Math.max(L, (long) coins[first][0]) + 1)
                * coins[first][2];

        total += firstPart - firstFull;

        // Correct the last segment for partial coverage.
        long lastFull =
                ((long) coins[last][1] - coins[last][0] + 1)
                * coins[last][2];

        long lastPart =
                (Math.min(R, (long) coins[last][1])
                - coins[last][0] + 1)
                * coins[last][2];

        total += lastPart - lastFull;

        return total;
    }
}
