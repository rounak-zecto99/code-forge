class Tuple {
    int index;
    long presum;

    Tuple(int index, long presum) {
        this.index = index;
        this.presum = presum;
    }
}

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Tuple> deque = new ArrayDeque<>();
        deque.offerLast(new Tuple(-1, 0));

        long pres = 0;
        int best = nums.length + 1;

        for (int i = 0; i < nums.length; i++) {
            pres += nums[i];

            while (!deque.isEmpty() && pres - deque.peekFirst().presum >= k) {
                best = Math.min(best, i - deque.peekFirst().index);
                deque.removeFirst();
            }

            while (!deque.isEmpty() && deque.peekLast().presum >= pres) {
                deque.removeLast();
            }

            deque.offerLast(new Tuple(i, pres));
        }

        return best == nums.length + 1 ? -1 : best;
    }
}
