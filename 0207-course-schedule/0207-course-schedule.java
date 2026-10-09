class Solution {
    boolean[] vis;
    boolean[] path;

    boolean dfs(int node, List<List<Integer>> list) {
        vis[node] = true;
        path[node] = true;

        for (int i : list.get(node)) {
            if (!vis[i] && dfs(i, list)) {
                return true;
            } else if (path[i]) {
                return true;
            }
        }
        path[node] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        int n = prerequisites.length;

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            list.get(b).add(a);
        }

        vis = new boolean[numCourses];
        path = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i] && dfs(i, list)) {
                return false;
            }
        }
        return true;
    }
}