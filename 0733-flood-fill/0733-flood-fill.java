
class Tuple {
    int row;
    int col;

    Tuple(int r, int c) {
        row = r;
        col = c;
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
        q.offer(new Tuple(sr, sc));

        // Mark when enqueuing
        image[sr][sc] = color;

        int[][] dirs = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!q.isEmpty()) {
            Tuple cur = q.poll();

            for (int[] d : dirs) {
                int row = cur.row + d[0];
                int col = cur.col + d[1];

                if (row >= 0 && row < m &&
                    col >= 0 && col < n &&
                    image[row][col] == reqColor) {

                    image[row][col] = color;
                    q.offer(new Tuple(row, col));
                }
            }
        }

        return image;
    }
}
