class tuple {
    int row;
    int col;

    tuple(int r, int c) {
        this.row = r;
        this.col = c;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<tuple> q = new ArrayDeque<>();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 0) {
                    q.offer(new tuple(row, col));
                } else {
                    mat[row][col] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            tuple cur = q.poll();

            int row = cur.row;
            int col = cur.col;

            // Up
            if (row > 0 && mat[row - 1][col] == -1) {
                mat[row - 1][col] = mat[row][col] + 1;
                q.offer(new tuple(row - 1, col));
            }

            // Down
            if (row + 1 < m && mat[row + 1][col] == -1) {
                mat[row + 1][col] = mat[row][col] + 1;
                q.offer(new tuple(row + 1, col));
            }

            // Left
            if (col > 0 && mat[row][col - 1] == -1) {
                mat[row][col - 1] = mat[row][col] + 1;
                q.offer(new tuple(row, col - 1));
            }

            // Right
            if (col + 1 < n && mat[row][col + 1] == -1) {
                mat[row][col + 1] = mat[row][col] + 1;
                q.offer(new tuple(row, col + 1));
            }
        }

        return mat;
    }
}