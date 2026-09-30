class Solution {
    static final long MOD = 1_000_000_007L;

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

        int[][] eng = new int[n][2];

        for (int i = 0; i < n; i++) {
            eng[i][0] = efficiency[i];
            eng[i][1] = speed[i];
        }

        Arrays.sort(eng, (a, b) -> Integer.compare(b[0], a[0]));

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        long speedsum = 0;
        long max = 0;

        for (int i = 0; i < n; i++) {

            speedsum += eng[i][1];
            heap.offer(eng[i][1]);

            if (heap.size() > k) {
                speedsum -= heap.poll();
            }

            long performance = speedsum * eng[i][0];
            max = Math.max(max, performance);
        }

        return (int) (max % MOD);
    }
}