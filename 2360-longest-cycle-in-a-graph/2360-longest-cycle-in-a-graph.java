class Solution {
    boolean [] vis;
    public int longestCycle(int[] edges) {

        int n = edges.length;

        vis = new boolean[n];

        int max = -1;

        for(int i=0; i<n; i++){
            if(!vis[i]){
                int [] pathVis = new int[n];
                pathVis[i] = 1;
                max = Math.max(max,dfs(edges,i,1,pathVis));
            }
        }
        return max;
    }
    int dfs(int[] edges ,int node, int pref,int []pathVis){

        if(node == -1)
        return node;

        if(vis[node] && pathVis[node] != 0)
        return pref - pathVis[node];

        if(vis[node])
        return -1;

        vis[node] = true;

        pathVis[node] = pref;

        return dfs(edges,edges[node],pref+1,pathVis);

    }
}