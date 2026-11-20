class Solution {
    public int minSubarray(int[] nums, int p) {

        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        map.computeIfAbsent(0, k -> new PriorityQueue<>(Collections.reverseOrder())).offer(0);

        //0 for suffix only divisibility

        int preSum = 0;
        int taken = 0;

        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            preSum = (preSum + nums[i]) % p;

            if (preSum % p == 0)
                taken = i + 1;

            map.computeIfAbsent(preSum, k -> new PriorityQueue<>(Collections.reverseOrder())).offer(i + 1);
        }

        int sufsum = 0;

        for (int i = n - 1; i >= 0; i--) {

            sufsum = (sufsum + nums[i]) %p;

            int rem = (p - sufsum) %p;

            if (map.containsKey(rem)) {

                PriorityQueue<Integer> heap = map.get(rem);

                while (!heap.isEmpty() && heap.peek() + n - i > n) {
                    heap.poll(); //pulls out all the stale element
                }

                if (!heap.isEmpty()) {
                    int nu = heap.peek() + n - i;

                    if (nu == n)
                        return 0;

                    taken = Math.max(taken, nu);
                }

            }

        }
        return taken == 0 ? -1 : n - taken;
    }
}