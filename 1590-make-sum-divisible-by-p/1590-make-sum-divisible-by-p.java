
class Solution {
    public int minSubarray(int[] nums, int p) {

        HashMap<Integer, Deque<Integer>> map = new HashMap<>();
        map.computeIfAbsent(0, k -> new ArrayDeque<>()).offerLast(0);

        int preSum = 0;
        int taken = 0;
        int n = nums.length;

        // Build prefix remainder map
        for (int i = 0; i < n; i++) {
            preSum = (preSum + nums[i]) % p;

            if (preSum == 0)
                taken = i + 1;

            map.computeIfAbsent(preSum, k -> new ArrayDeque<>())
               .offerLast(i + 1);
        }

        int sufsum = 0;

        // Traverse suffixes backwards
        for (int i = n - 1; i >= 0; i--) {

            sufsum = (sufsum + nums[i]) % p;

            int rem = (p - sufsum) % p;

            if (map.containsKey(rem)) {

                Deque<Integer> deque = map.get(rem);

                while (!deque.isEmpty() && deque.peekLast() > i) {
                    deque.pollLast();
                }

                if (!deque.isEmpty()) {

                    int nu = deque.peekLast() + n - i;

                    if (nu == n)
                        return 0;

                    taken = Math.max(taken, nu);
                }
            }
        }

        return taken == 0 ? -1 : n - taken;
    }
}
