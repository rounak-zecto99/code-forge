class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int sr = startPos[0];
        int sc = startPos[1];
        int m = rowCosts.length;

        int fr = homePos[0];
        int fc = homePos[1];
        int n = colCosts.length;

        int cost = 0;

        while (sr > fr) {
            cost += rowCosts[sr - 1];
            sr = sr - 1;
        }
        while (sr < fr) {
            cost += rowCosts[sr + 1];
            sr = sr + 1;
        }
        while (sc > fc) {
            cost += colCosts[sc - 1];
            sc = sc - 1;
        }
        while (sc < fc) {
            cost += colCosts[sc + 1];
            sc = sc + 1;
        }

        return cost;
    }
}