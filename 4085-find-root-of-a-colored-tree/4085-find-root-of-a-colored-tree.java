class Solution {
    public int findColoredRoot(int[][] edges, String colors) {

        int nodes = colors.length();

        int[] inDeg = new int[nodes];
        int[] outDeg = new int[nodes];

        for (int[] edge : edges) {

            int a = edge[0];
            int b = edge[1];

            char colourA = colors.charAt(a);
            char colourB = colors.charAt(b);

            if((colourA ^ colourB) == 0)
            return -1;

            if (colourA == 'R') {
                if (colourB == 'B') {
                    if (++inDeg[b] > 1) {
                        return -1;
                    }
                    outDeg[a]++;
                } else {
                    if (++inDeg[a] > 1) {
                        return -1;
                    }
                    outDeg[b]++;
                }
            } else if (colourA == 'W') {
                if (colourB == 'R') {
                    if (++inDeg[b] > 1) {
                        return -1;
                    }
                    outDeg[a]++;
                } else {
                    if (++inDeg[a] > 1) {
                        return -1;
                    }
                    outDeg[b]++;
                }
            } else {
                if (colourB == 'W') {
                    if (++inDeg[b] > 1) {
                        return -1;
                    }
                    outDeg[a]++;
                } else {
                    if (++inDeg[a] > 1) {
                        return -1;
                    }
                    outDeg[b]++;
                }
            }
        }
        int root = 0;
        boolean found = false;
        for(int i=0; i<nodes; i++){
            if(inDeg[i] == 0 && found)
            return -1;

            if(inDeg[i] == 0)
            root = i;

            if(outDeg[i] > 2 )
            return -1;
        }
        return root;
    }
}