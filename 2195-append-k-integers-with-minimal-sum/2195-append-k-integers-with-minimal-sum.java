class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);

        long sum = 0;
        long next = 1;

        for (int num : nums) {

            if (next < num) {
                long count = Math.min((long) k, num - next);

                long end = next + count - 1;

                // sum of next ... end
                sum += end * (end + 1) / 2
                     - (next - 1) * next / 2;

                k -= count;

                if (k == 0)
                    return sum;
            }

            // num is already present, so move past it
            next = Math.max(next, (long) num + 1);
        }

        // Still need more numbers after the largest element
        if (k > 0) {
            long end = next + k - 1;

            sum += end * (end + 1) / 2
                 - (next - 1) * next / 2;
        }

        return sum;
    }
}