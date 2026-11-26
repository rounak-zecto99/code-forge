class Solution {
    int INF = Integer.MAX_VALUE;

    public int minActivationCost(int[][] edges, int[] values) {

        int n = values.length;
        int ans = INF;

        int[] bestEdge = new int[n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int cost = edge[2];

            int parityU = Integer.bitCount(values[u]) & 1;
            int parityV = Integer.bitCount(values[v]) & 1;

            if (parityU == parityV) {
                ans = Math.min(ans, cost);
            } else {
                int zeroNode = parityU == 0 ? u : v;

                if (bestEdge[zeroNode] != 0) {
                    ans = Math.min(ans, bestEdge[zeroNode] + cost);
                }
                if (bestEdge[zeroNode] == 0 || cost < bestEdge[zeroNode]) {
                    bestEdge[zeroNode] = cost;
                }
            }
        }
        return ans == INF ? -1 : ans;
    }
}