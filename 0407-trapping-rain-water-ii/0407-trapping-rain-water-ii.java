class Cell {
    int height;
    int row;
    int col;

    Cell(int h, int r, int c) {
        this.height = h;
        this.row = r;
        this.col = c;
    }
}

class Solution {
    int[] dr = { 0, 0, 1, -1 };
    int[] dc = { 1, -1, 0, 0 };

    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<Cell> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.height, b.height));

        int m = heightMap.length;
        int n = heightMap[0].length;

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        boolean[][] vis = new boolean[m][n];

        for (int j = left; j <= right; j++) {
            vis[top][j] = true;
            queue.offer(new Cell(heightMap[top][j], top, j));
        }
        top++;

        for (int j = top; j <= bottom; j++) {
            vis[j][right] = true;
            queue.offer(new Cell(heightMap[j][right], j, right));
        }
        right--;

        for (int j = right; j >= left; j--) {
            vis[bottom][j] = true;
            queue.offer(new Cell(heightMap[bottom][j], bottom, j));
        }
        bottom--;
        for (int i = bottom; i >= top; i--) {
            vis[i][left] = true;
            queue.offer(new Cell(heightMap[i][left], i, left));
        }
        left++;

        int cost = 0;

        while (!queue.isEmpty()) {
            int h = queue.peek().height;
            int r = queue.peek().row;
            int c = queue.peek().col;

            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n) {
                    continue;
                }

                if (vis[nr][nc])
                    continue;

                vis[nr][nc] = true;

                int nHeight = heightMap[nr][nc];
                int newHeight = Math.max(h, nHeight);

                cost += newHeight - nHeight;

                queue.offer(new Cell(newHeight, nr, nc));
            }
        }
        return cost;
    }
}