class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        TreeSet<Integer> idle = new TreeSet<>();

        for (int i = 0; i < k; i++) {
            idle.add(i);
        }

        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] count = new int[k];

        for (int i = 0; i < arrival.length; i++) {

            int time = arrival[i];

            // Free servers that have completed their requests
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                int server = busy.poll()[1];
                idle.add(server);
            }

            if (idle.isEmpty()) {
                continue;
            }

            int preferred = i % k;

            // Find the first available server >= preferred
            Integer server = idle.ceiling(preferred);

            // Wrap around if necessary
            if (server == null) {
                server = idle.first();
            }

            idle.remove(server);

            count[server]++;

            busy.offer(new int[]{time + load[i], server});
        }

        int max = 0;

        for (int c : count) {
            max = Math.max(max, c);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                ans.add(i);
            }
        }

        return ans;
    }
}