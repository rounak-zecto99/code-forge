class Solution {
    boolean[] vis;
    int[] pathVis;
    int timer = 1;

    public int longestCycle(int[] edges) {

        int n = edges.length;

        vis = new boolean[n];
        pathVis = new int[n];

        int max = -1;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                max = Math.max(max, dfs(edges, i, 1));
                timer++;
            }
        }

        return max;
    }

    int dfs(int[] edges, int node, int pref) {

        if (node == -1)
            return -1;

        if (vis[node]) {
            if (pathVis[node] / 1000000 == timer)
                return pref - (pathVis[node] % 1000000);

            return -1;
        }

        vis[node] = true;
        pathVis[node] = timer * 1000000 + pref;

        return dfs(edges, edges[node], pref + 1);
    }
}