class Tuple {
    int row;
    int col;

    Tuple(int r, int c) {
        this.row = r;
        this.col = c;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int reqColor = image[sr][sc];

        if (color == reqColor)
            return image;

        int m = image.length;
        int n = image[0].length;

        Queue<Tuple> q = new ArrayDeque<>();
        image[sr][sc] = color;
        q.offer(new Tuple(sr, sc));

        while (!q.isEmpty()) {
            Tuple cur = q.poll();

            int row = cur.row;
            int col = cur.col;

            if (row > 0 && image[row - 1][col] == reqColor) {
                image[row - 1][col] = color;
                q.offer(new Tuple(row - 1, col));
            }

            if (row + 1 < m && image[row + 1][col] == reqColor) {
                image[row + 1][col] = color;
                q.offer(new Tuple(row + 1, col));
            }
            if (col > 0 && image[row][col - 1] == reqColor) {
                image[row][col - 1] = color;
                q.offer(new Tuple(row, col - 1));
            }
            if (col + 1 < n && image[row][col + 1] == reqColor) {
                image[row][col + 1] = color;
                q.offer(new Tuple(row, col + 1));
            }
        }
        return image;
    }
}