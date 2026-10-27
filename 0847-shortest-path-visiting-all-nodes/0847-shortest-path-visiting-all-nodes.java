class Pair {
    int node;
    int vis;

    Pair(int x, int z) {
        this.node = x;
        this.vis = z;
    }
}

class Solution {
    public int shortestPathLength(int[][] graph) {

        int n = graph.length;
        int endingmask = (1 << n) - 1;

        boolean[][] seen = new boolean[n][1 << n];

        Queue<Pair> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int curMask = 1 << i;
            q.offer(new Pair(i, curMask));
            seen[i][curMask] = true;
        }

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {

                int node = q.peek().node;
                int mask = q.peek().vis;

                q.poll();

                if (mask == endingmask)
                    return steps;

                for (int neigh : graph[node]) {

                    int newMask = mask | (1 << neigh);
                    if (!seen[neigh][newMask]) {
                        seen[neigh][newMask] = true;
                        q.offer(new Pair(neigh, newMask));
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}