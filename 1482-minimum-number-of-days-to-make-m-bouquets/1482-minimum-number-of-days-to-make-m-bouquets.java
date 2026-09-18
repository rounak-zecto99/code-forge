class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > (long) bloomDay.length)
            return -1;

        int start = 1;
        int end = 1_000_000_000;

        // for (int x : bloomDay) {
        //     start = Math.min(start, x);
        //     end = Math.max(end, x);
        // }

        while (start < end) {
            int days = start + ((end - start) >> 1);
            int bouq = 0;
            int left = 0;

            for (int i = 0; i < bloomDay.length; i++) {
                if (days < bloomDay[i]) {
                    left = i + 1;
                }
                if (i - left + 1 == k) {
                    bouq++;
                    left = i + 1;
                }
            }
            if (bouq < m) {
                start = days + 1;
            } else {
                end = days;
            }
        }
        return end;
    }
}