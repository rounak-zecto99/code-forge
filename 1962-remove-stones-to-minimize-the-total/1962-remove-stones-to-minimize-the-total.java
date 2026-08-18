class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        long sum = 0;

        for (int pile : piles) {
            maxHeap.offer(pile);
            sum += pile;
        }

        while (k-- > 0) {
            int x = maxHeap.poll();
            int newVal = (x + 1) / 2;

            sum -= (x - newVal);

            maxHeap.offer(newVal);
        }

        return (int) sum;
    }
}