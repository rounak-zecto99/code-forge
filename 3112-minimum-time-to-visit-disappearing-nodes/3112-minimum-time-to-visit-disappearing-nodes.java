
import java.util.*;

class Pair {
    int distance;
    int node;

    Pair(int d, int nx) {
        this.distance = d;
        this.node = nx;
    }
}

class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        Map<Integer, List<Pair>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int time = edge[2];

            graph.computeIfAbsent(a, k -> new ArrayList<>())
                 .add(new Pair(time, b));

            graph.computeIfAbsent(b, k -> new ArrayList<>())
                 .add(new Pair(time, a));
        }

        int INF = (int) 1e9;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) ->
                Integer.compare(a.distance, b.distance));

        dist[0] = 0;
        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            int dis = curr.distance;
            int node = curr.node;

            if (dis > dist[node]) {
                continue;
            }

            for (Pair neighbour :
                    graph.getOrDefault(node, Collections.emptyList())) {

                int nextNode = neighbour.node;
                int nextDis = dis + neighbour.distance;

                if (nextDis < dist[nextNode]
                        && nextDis < disappear[nextNode]) {

                    dist[nextNode] = nextDis;
                    pq.offer(new Pair(nextDis, nextNode));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == INF) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
