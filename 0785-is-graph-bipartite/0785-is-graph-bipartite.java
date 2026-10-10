
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] col = new int[n];
        Arrays.fill(col, -1);

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (col[i] != -1) continue;

            q.offer(i);
            col[i] = 0;

            while (!q.isEmpty()) {
                int node = q.poll();

                for (int nei : graph[node]) {
                    if (col[nei] == -1) {
                        col[nei] = col[node] ^ 1;
                        q.offer(nei);
                    } else if (col[nei] == col[node]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
