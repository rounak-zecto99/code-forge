class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = tasks.length;

        int[] ans = new int[n];

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (servers[a[0]] != servers[b[0]]) {
                return Integer.compare(servers[a[0]], servers[b[0]]);
            }
            return Integer.compare(a[0], b[0]);
        });

        for (int i = 0; i < servers.length; i++) {
            q.offer(new int[] { i, 0 });
        }

        int time = 0;
        int i = 0;

        PriorityQueue<int[]> processingQueue = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));

        while (i < n) {
            time = Math.max(time, i);

            while (!processingQueue.isEmpty() && processingQueue.peek()[1] <= time) {
                q.offer(processingQueue.poll());
            }

            if (q.isEmpty()) {
                time = processingQueue.peek()[1];
                continue;
            }
            ans[i] = q.peek()[0];

            int[] cur = q.poll();
            cur[1] = tasks[i] + time;

            processingQueue.offer(cur);
            i++;
        }

        return ans;

    }
}