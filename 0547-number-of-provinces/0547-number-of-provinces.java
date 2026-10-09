class Solution {
    boolean[] vis;
    List<List<Integer>> list;

    void dfs(int node) {
        vis[node] = true;

        for (int i : list.get(node)) {
            if (!vis[i])
                dfs(i);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        vis = new boolean[n];
        int count = 0;
        // System.out.println(list);

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                count++;
                dfs(i);
            }
        }
        return count;
    }
}