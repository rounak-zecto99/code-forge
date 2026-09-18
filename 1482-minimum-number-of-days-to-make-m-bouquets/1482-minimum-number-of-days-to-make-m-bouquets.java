class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length)
            return -1;

        int low = 1;
        int high = 1_000_000_000;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, m, k, mid))
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int consecutive = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                consecutive++;

                if (consecutive == k) {
                    bouquets++;
                    consecutive = 0;

                    if (bouquets == m)
                        return true;
                }
            } else {
                consecutive = 0;
            }
        }

        return false;
    }
}