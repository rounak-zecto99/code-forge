class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int bits = 32 - Integer.numberOfLeadingZeros(x);
        long r = 1L << ((bits + 1) >> 1);

        while (r > x / r) {
            r = (r + x / r) >> 1;
        }

        return (int) r;
    }
}