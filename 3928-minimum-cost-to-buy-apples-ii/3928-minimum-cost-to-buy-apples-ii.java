
class Tuple {
    long distance;
    int node;

    Tuple(long d, int n) {
        this.distance = d;
        this.node = n;
    }
}

class Edge {
    int node;
    long forwardCost;
    long backwardCost;

    Edge(int node, long forwardCost, long backwardCost) {
        this.node = node;
        this.forwardCost = forwardCost;
        this.backwardCost = backwardCost;
    }
}

class Solution {

    long inf = Long.MAX_VALUE;

    public int[] minCost(int n, int[] prices, int[][] roads) {

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] cur : roads) {
            int u = cur[0];
            int v = cur[1];

            long cost = cur[2];
            long tax = cost * cur[3];

            graph.get(u).add(new Edge(v, cost, tax));
            graph.get(v).add(new Edge(u, cost, tax));
        }

        int[] ans = Arrays.copyOf(prices, n);

        for (int i = 0; i < n; i++) {

            long limit = prices[i];

            long[] forward = dijkstra(graph, i, limit, false);
            long[] backward = dijkstra(graph, i, limit, true);

            for (int j = 0; j < n; j++) {

                if (forward[j] == inf || backward[j] == inf)
                    continue;

                long total = (long) prices[j] + forward[j] + backward[j];

                if (total < ans[i])
                    ans[i] = (int) total;
            }
        }

        return ans;
    }

    public long[] dijkstra(List<List<Edge>> graph, int start,
                           long limit, boolean carrying) {

        int n = graph.size();

        long[] dis = new long[n];
        Arrays.fill(dis, inf);

        PriorityQueue<Tuple> pq =
            new PriorityQueue<>((a, b) ->
                Long.compare(a.distance, b.distance));

        pq.offer(new Tuple(0, start));
        dis[start] = 0;

        while (!pq.isEmpty()) {

            Tuple cur = pq.poll();

            long distance = cur.distance;
            int node = cur.node;

            if (distance > dis[node])
                continue;

            for (Edge edge : graph.get(node)) {

                int nextNode = edge.node;

                long weight = carrying
                    ? edge.backwardCost
                    : edge.forwardCost;

                long nextDistance = distance + weight;

                if (nextDistance < dis[nextNode]
                        && nextDistance <= limit) {

                    dis[nextNode] = nextDistance;

                    pq.offer(new Tuple(nextDistance, nextNode));
                }
            }
        }

        return dis;
    }
}
