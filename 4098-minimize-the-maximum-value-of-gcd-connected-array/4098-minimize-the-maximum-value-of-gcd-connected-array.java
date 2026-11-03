
class Solution {
    public long minimumMaxValue(int n, int index, int value) {

        if (value == 1) {
            return -1;
        }

        int p = smallestPrimeFactor(value);

        if ( value - p < 2L * index) {
            return -1;
        }

        if (index == n - 1) {
            return value;
        }

        long t = n - index - 1;

        return value + p + 2L * (t - 1);
    }

    private int smallestPrimeFactor(int x) {
        for (int p = 2; p * p <= x; p++) {
            if (x % p == 0) {
                return p;
            }
        }

        return x;
    }
}
