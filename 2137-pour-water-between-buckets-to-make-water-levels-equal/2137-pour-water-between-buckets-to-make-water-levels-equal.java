class Solution {
    public double equalizeWater(int[] buckets, int los) {
        double start = Double.MAX_VALUE;
        double total = 0.0;
        int n = buckets.length;

        double loss = los / 100.0;

        for (int x : buckets) {
            start = Math.min(start, x);
            total += x;
        }

        double end = total / n;

        while (end - start > 1e-5) {
            double mid = start + (end - start) / 2.0;
            double balance = 0.0;

            for (int x : buckets) {
                if (x > mid) {
                    balance += (x - mid) * (1.0 - loss);
                } else {
                    balance -= (mid - x);
                }
            }

            if (balance >= 0.0) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return end;
    }
}