class Solution {
    public long maximumCoins(int[][] coins, int k) {
        Arrays.sort(coins, (a, b) -> Integer.compare(a[0], b[0]));

        int n = coins.length;
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i]
                    + (long) (coins[i][1] - coins[i][0] + 1) * coins[i][2];
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            long right = (long) coins[i][0] + k - 1;

            int start = i, end = n;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (coins[mid][0] <= right) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }

            int j = start - 1;
            long sum = prefix[j + 1] - prefix[i];

            if (coins[j][1] > right) {
                sum -= (long) (coins[j][1] - right) * coins[j][2];
            }

            ans = Math.max(ans, sum);
        }

        for (int[] coin : coins) {
            int left = coin[0];
            coin[0] = -coin[1];
            coin[1] = -left;
        }

        Arrays.sort(coins, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.fill(prefix, 0);

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i]
                    + (long) (coins[i][1] - coins[i][0] + 1) * coins[i][2];
        }

        for (int i = 0; i < n; i++) {
            long right = (long) coins[i][0] + k - 1;

            int start = i, end = n;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (coins[mid][0] <= right) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }

            int j = start - 1;
            long sum = prefix[j + 1] - prefix[i];

            if (coins[j][1] > right) {
                sum -= (long) (coins[j][1] - right) * coins[j][2];
            }

            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
