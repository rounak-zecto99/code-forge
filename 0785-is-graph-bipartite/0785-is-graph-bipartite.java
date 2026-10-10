class Solution {
    boolean[] vis;
    int[] col;

    boolean bfs(int ver, int[][] graph) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(ver);
        col[ver] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            vis[node] = true;

            for (int i : graph[node]) {
                if (!vis[i]) {
                    vis[i] = true;
                    col[i] = col[node] ^ 1;
                    q.offer(i);
                } else if (col[node] == col[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        vis = new boolean[n];
        col = new int[n];
        // Arrays.fill(col, -1);
        for (int i = 0; i < n; i++) {
            if (!vis[i] && !bfs(i, graph)) {
                return false;
            }
        }
        return true;
    }
}