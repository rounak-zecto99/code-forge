class Solution {
    public long sumAndMultiply(int n) {
        int ans = 0;
        int count = 0;

        int mask = 1000_000_000;

        while (mask > 0) {
            int front = n / mask;

            int digit = front % 10;
            mask = mask / 10;

            if (digit == 0)
                continue;

            ans = ans * 10 + digit;

            count += digit;
        }

        return (long) ans * count;
    }
}