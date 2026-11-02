import java.util.*;

class Solution {
    public int minTotalDistance(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int size = 0;

        for (int[] row : grid) {
            for (int val : row) {
                size += val;
            }
        }

        int[] rows = new int[size];
        int[] cols = new int[size];

        int idx = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows[idx] = i;
                    cols[idx] = j;
                    idx++;
                }
            }
        }

        Arrays.sort(cols);

        int medianRow = rows[size >> 1];
        int medianCol = cols[size >> 1];

        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += Math.abs(medianRow - rows[i]);
            sum += Math.abs(medianCol - cols[i]);
        }

        return sum;
    }
}