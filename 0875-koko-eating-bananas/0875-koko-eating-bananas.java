class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int start = 1;
        int end = piles[0];
        for (int x : piles) {
            end = Math.max(end, x);
        }
        int times;

        while (start < end) {

            int mid = start + ((end - start) >> 1);
            times = 0;
            for (int i = 0; i < piles.length; i++) {
                if (times > h) {
                    break;
                }
                int pile = piles[i];
                times += (pile + mid - 1) / mid;

            }
            if (times > h) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}