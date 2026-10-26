class Solution {
    public int mySqrt(int x) {
        long s = 0;
        long e = x;

        while (s < e) {
            long m = s + ((e - s + 1) >> 1);

            if (m * m > x) {
                e =(long) m - 1;
            } else {
                s = m;
            }
        }
        return (int)s;
    }
}