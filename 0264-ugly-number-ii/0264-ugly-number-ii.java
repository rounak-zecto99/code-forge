class Solution {
    static int[] ugly = new int[1691];

    static {
        ugly[1] = 1;

        int i2 = 1, i3 = 1, i5 = 1;

        for (int i = 2; i <= 1690; i++) {
            int a = ugly[i2] * 2;
            int b = ugly[i3] * 3;
            int c = ugly[i5] * 5;

            int next = Math.min(a, Math.min(b, c));
            ugly[i] = next;

            if (next == a) i2++;
            if (next == b) i3++;
            if (next == c) i5++;
        }
    }

    public int nthUglyNumber(int n) {
        return ugly[n];
    }
}