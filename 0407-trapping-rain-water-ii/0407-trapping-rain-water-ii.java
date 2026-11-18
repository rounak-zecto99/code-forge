import java.util.Arrays;

class Solution {

    private static final int MAX_HEIGHT = 20000;

    private static final int[] dr = {0, 0, 1, -1};
    private static final int[] dc = {1, -1, 0, 0};

    public int trapRainWater(int[][] heightMap) {

        int m = heightMap.length;
        int n = heightMap[0].length;

        if (m < 3 || n < 3) return 0;

        int total = m * n;

        // Bucket heads: head[h] stores the first cell with effective height h.
        int[] head = new int[MAX_HEIGHT + 1];
        Arrays.fill(head, -1);

        // Linked-list pointer for each cell.
        int[] next = new int[total];

        boolean[] visited = new boolean[total];

        // Insert top and bottom boundaries.
        for (int c = 0; c < n; c++) {

            int topIdx = c;
            int topHeight = heightMap[0][c];

            visited[topIdx] = true;
            next[topIdx] = head[topHeight];
            head[topHeight] = topIdx;

            int bottomIdx = (m - 1) * n + c;
            int bottomHeight = heightMap[m - 1][c];

            visited[bottomIdx] = true;
            next[bottomIdx] = head[bottomHeight];
            head[bottomHeight] = bottomIdx;
        }

        // Insert left and right boundaries, excluding corners.
        for (int r = 1; r < m - 1; r++) {

            int leftIdx = r * n;
            int leftHeight = heightMap[r][0];

            visited[leftIdx] = true;
            next[leftIdx] = head[leftHeight];
            head[leftHeight] = leftIdx;

            int rightIdx = r * n + n - 1;
            int rightHeight = heightMap[r][n - 1];

            visited[rightIdx] = true;
            next[rightIdx] = head[rightHeight];
            head[rightHeight] = rightIdx;
        }

        int water = 0;
        int level = 0;

        while (level <= MAX_HEIGHT) {

            // Find the smallest available effective height.
            while (level <= MAX_HEIGHT && head[level] == -1) {
                level++;
            }

            if (level > MAX_HEIGHT) break;

            // Remove one cell from this bucket.
            int idx = head[level];
            head[level] = next[idx];

            int r = idx / n;
            int c = idx % n;

            // Explore its four neighbours.
            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n) {
                    continue;
                }

                int ni = nr * n + nc;

                if (visited[ni]) continue;

                visited[ni] = true;

                int terrainHeight = heightMap[nr][nc];

                int effectiveHeight = Math.max(level, terrainHeight);

                water += effectiveHeight - terrainHeight;

                // Insert into the bucket for its effective height.
                next[ni] = head[effectiveHeight];
                head[effectiveHeight] = ni;
            }
        }

        return water;
    }
}