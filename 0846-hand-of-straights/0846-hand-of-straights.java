class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0)
            return false;

        HashMap<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : hand) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : freq.keySet()) {
            heap.offer(num);
        }

        while (!heap.isEmpty()) {

            int start = heap.peek();

            for (int i = 0; i < groupSize; i++) {

                int card = start + i;

                if (freq.getOrDefault(card, 0) == 0)
                    return false;

                freq.put(card, freq.get(card) - 1);
            }

            while (!heap.isEmpty() &&
                   freq.get(heap.peek()) == 0) {
                heap.poll();
            }
        }

        return true;
    }
}