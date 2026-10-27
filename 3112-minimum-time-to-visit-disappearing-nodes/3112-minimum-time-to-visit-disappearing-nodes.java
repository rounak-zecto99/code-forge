class Pair {
    int distance;
    int node;

    Pair(int d, int nx) {
        this.node = nx;
        this.distance = d;
    }
}

class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {

        Map<Integer, List<Pair>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            int stretch = edge[2];

            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(new Pair(stretch, b));
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(new Pair(stretch, a));
        }
        // int h = disappear.length;

        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Integer.compare(a.distance, b.distance));

        dist[0] = 0;
        q.offer(new Pair(0, 0));

        // boolean[] vis = new boolean[n];

        while (!q.isEmpty()) {
            int dis = q.peek().distance;
            int node = q.peek().node;
            q.poll();

            if (dis > dist[node])
                continue;

            for (Pair neighbour : graph.getOrDefault(node, new ArrayList<>())) {
                int nextDis = neighbour.distance;
                int nextNode = neighbour.node;

                if (dis + nextDis < dist[nextNode] && dis + nextDis < disappear[nextNode]) {
                    dist[nextNode] = dis + nextDis;
                    q.offer(new Pair(dist[nextNode],nextNode));
                }
            }
        }
        // System.out.println(Arrays.toString(dist));
        for(int i=0; i<disappear.length; i++){
            disappear[i] = dist[i] == (int)(1e9) ? -1 : dist[i];
        }
        return disappear;
    }
}