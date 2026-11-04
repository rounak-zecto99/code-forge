class Pair {
    int node;
    long time;

    Pair(int node, long time) {
        this.node = node;
        this.time = time;
    }
}

class Solution {

    int mod = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {

        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            int time = road[2];

            graph.get(a).add(new Pair(b, time));
            graph.get(b).add(new Pair(a, time));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        int[] ways = new int[n];

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) ->
                Long.compare(a.time, b.time));

        dist[0] = 0;
        ways[0] = 1;

        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int node = curr.node;
            long time = curr.time;

            // Ignore outdated entries
            if (time > dist[node]) {
                continue;
            }

            for (Pair neighbour : graph.get(node)) {

                int nextNode = neighbour.node;
                long newTime = time + neighbour.time;

                // Found a shorter path
                if (newTime < dist[nextNode]) {

                    dist[nextNode] = newTime;

                    ways[nextNode] = ways[node];

                    pq.offer(new Pair(nextNode, newTime));
                }

                // Found another shortest path
                else if (newTime == dist[nextNode]) {

                    ways[nextNode] =
                        (ways[nextNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1];
    }
}