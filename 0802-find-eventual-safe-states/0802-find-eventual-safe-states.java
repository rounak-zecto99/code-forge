class Solution {
    boolean[] vis;
    boolean[] path;
    boolean[] checked;

    public boolean dfs(int node, int[][] graph) {
        vis[node] = true;
        path[node] =true;

        for (int i : graph[node]) {
            if (!vis[i]) {
                if (dfs(i, graph)) {
                    return true;
                }
            } else if (path[i]) {
                return true;
            }
        }
        checked[node] = true;
        path[node] = false;
        return false;

    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        vis = new boolean[n];
        path = new boolean[n];
        checked = new boolean[n];

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, graph);
            }
        }

        for (int i = 0; i < n; i++) {
            if (checked[i]) {
                list.add(i);
            }
        }
        return list;
    }
}