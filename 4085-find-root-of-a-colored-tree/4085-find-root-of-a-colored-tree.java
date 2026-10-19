class Solution {

    public int colorId(char c) {
        if (c == 'R')
            return 0;
        if (c == 'B')
            return 1;
        return 2;
    }

    public int findColoredRoot(int[][] edges, String colors) {

        int nodes = colors.length();

        int[] inDeg = new int[nodes];
        int[] outDeg = new int[nodes];

        for (int[] edge : edges) {

            int a = edge[0];
            int b = edge[1];

            int ca = colorId(colors.charAt(a));
            int cb = colorId(colors.charAt(b));

            if (ca == cb)
                return -1;

            if ((ca + 1) % 3 == cb) {
                if (++inDeg[b] > 1)
                    return -1;
                outDeg[a]++;
            } else {
                if (++inDeg[a] > 1)
                    return -1;
                outDeg[b]++;
            }
        }

        int root = -1;

        for (int i = 0; i < nodes; i++) {

            if (outDeg[i] > 2)
                return -1;

            if (inDeg[i] == 0) {
                if (root != -1)
                    return -1;
                root = i;
            }
        }

        return root;
    }
}