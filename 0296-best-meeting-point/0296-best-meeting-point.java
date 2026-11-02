class Solution {
    public int minTotalDistance(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        Collections.sort(cols);

        int medianRow = rows.get(rows.size() >> 1);
        int medianCol = cols.get(cols.size() >> 1);

        int sumrow = 0;
        int sumcol = 0;

        for(int i= 0; i<rows.size(); i++){
            sumrow += Math.abs(medianRow - rows.get(i));
            sumcol += Math.abs(medianCol - cols.get(i));
        }

        return sumrow + sumcol;

    }
}