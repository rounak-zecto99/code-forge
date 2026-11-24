class Tuple {
    long distance;
    int node;

    Tuple(long d, int n) {
        this.distance = d;
        this.node = n;
    }
}

class Solution {

    long inf = (long) Integer.MAX_VALUE;

    public int[] minCost(int n, int[] prices, int[][] roads) {

        Map<Integer, List<Tuple>> travel = new HashMap<>();
        Map<Integer, List<Tuple>> returning = new HashMap<>();

        for (int[] cur : roads) {
            int node1 = cur[0];
            int node2 = cur[1];

            int cost = cur[2];
            long tax = (long) cost * cur[3];

            travel.computeIfAbsent(node1, k -> new ArrayList<>()).add(new Tuple(cost,node2));
            travel.computeIfAbsent(node2, k -> new ArrayList<>()).add(new Tuple(cost,node1));

            returning.computeIfAbsent(node1, k -> new ArrayList<>()).add(new Tuple(tax,node2));
            returning.computeIfAbsent(node2, k -> new ArrayList<>()).add(new Tuple(tax,node1));
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            long[] forward = new long[n];
            long[] backward = new long[n];

            for (int index = 0; index < n; index++) {
                forward[index] = inf;
                backward[index] = inf;
            }

            long best = prices[i];

            dijkstra(travel, forward, i, best);
            dijkstra(returning, backward, i, best);

            for (int j = 0; j < n; j++) {
                best = Math.min(best,(long) prices[j] + forward[j] + backward[j]);
            }
            ans[i] = (int) best;
        }
        return ans;
    }

    public void dijkstra(Map<Integer, List<Tuple>> graph, long[] dis, int start, long limit) {

        PriorityQueue<Tuple> pq = 
                            new PriorityQueue<>((a, b) -> Long.compare(a.distance, b.distance));

        pq.offer(new Tuple(0, start));
        dis[start] = 0;

        while (!pq.isEmpty()) {
            long distance = pq.peek().distance;
            int node = pq.peek().node;

            pq.poll();

            if (dis[node] < distance)
                continue;

            for (Tuple neigh : graph.getOrDefault(node, Collections.emptyList())) {
                int nextNode = neigh.node;
                long nextDis = neigh.distance;

                if (nextDis + distance < dis[nextNode] && nextDis <= limit) {
                    dis[nextNode] = nextDis + distance;
                    pq.offer(new Tuple(dis[nextNode], nextNode));
                }
            }
        }
    }
}