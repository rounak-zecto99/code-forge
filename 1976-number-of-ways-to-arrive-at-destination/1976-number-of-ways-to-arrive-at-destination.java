class Pair {
    int node;
    long time;

    Pair(int node, long time) {
        this.node = node;
        this.time = time;
    }
}

class Solution {
    int mod = 1000_000_007;

    public int countPaths(int n, int[][] roads) {

        int len = roads.length;

        Map<Integer, List<Pair>> graph = new HashMap<>();

        for (int[] i : roads) {
            int a = i[0];
            int b = i[1];

            int time = i[2];

            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(new Pair(b, time));
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(new Pair(a, time));
        }

        long[] timeStamp = new long[n];
        Arrays.fill(timeStamp, Long.MAX_VALUE);

        int[] ways = new int[n];
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));

        pq.offer(new Pair(0, 0));
        timeStamp[0] = 0;

        while (!pq.isEmpty()) {

            int node = pq.peek().node;
            long timeTaken = pq.peek().time;

            pq.poll();

            if (timeStamp[node] < timeTaken)
                continue;

            for (Pair neighbour : graph.getOrDefault(node, Collections.emptyList())) {

                int nextNode = neighbour.node;
                long nextTime = neighbour.time + timeTaken;

                if (nextTime < timeStamp[nextNode]) {

                    timeStamp[nextNode] = nextTime;

                    ways[nextNode] = ways[node];

                    pq.offer(new Pair(nextNode, nextTime));

                } 
                else if (nextTime == timeStamp[nextNode]) {
                   ways[nextNode] = (ways[nextNode] + ways[node]) % mod;
                }
            }

        }
        return ways[n - 1];
    }
}