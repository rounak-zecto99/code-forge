class Solution {
    public int mySqrt(int x) {

        if(x < 2)
        return x;

        long s = 1;
        long e = x>>1;

        while (s < e) {
            long m = s + ((e - s + 1) >> 1);

            if (m * m > x) {
                e = m - 1;
            } else {
                s = m;
            }
        }
        return (int)s;
    }
}