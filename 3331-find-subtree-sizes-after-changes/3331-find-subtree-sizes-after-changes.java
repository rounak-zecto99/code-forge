class Solution {

    List<Integer>[] graph;
    List<Integer>[] newGraph;

    int[] newParent;
    int[] ans;
    String s;

    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;
        this.s = s;

        graph = new ArrayList[n];
        newGraph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            newGraph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            graph[parent[i]].add(i);
        }

        newParent = parent.clone();

        int[] last = new int[26];
        Arrays.fill(last, -1);

        update(0, last);

        for (int i = 1; i < n; i++) {
            newGraph[newParent[i]].add(i);
        }

        ans = new int[n];
        calculate(0);

        return ans;
    }

    void update(int node, int[] last) {

        int c = s.charAt(node) - 'a';

        int old = last[c];

        if (old != -1) {
            newParent[node] = old;
        }

        last[c] = node;

        for (int child : graph[node]) {
            update(child, last);
        }

        last[c] = old;
    }

    int calculate(int node) {

        int size = 1;

        for (int child : newGraph[node]) {
            size += calculate(child);
        }

        return ans[node] = size;
    }
}