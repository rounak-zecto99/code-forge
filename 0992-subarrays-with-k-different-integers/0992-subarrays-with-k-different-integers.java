class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        int left = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            heap.offer(new int[]{nums[i], i});

            while (heap.peek()[1] != map.get(heap.peek()[0])) {
                heap.poll();
            }
            int minKey = heap.peek()[0];
            int boundary = heap.peek()[1];

            if (map.size() > k) {

                map.remove(minKey);
                left = boundary + 1;
                heap.poll();

            }
            while ( heap.peek()[1] != map.get(heap.peek()[0])) {
                heap.poll();
            }
            boundary = heap.peek()[1];

            if (map.size() == k) {
                count += boundary - left + 1;
            }
        }
        return count;
    }
}