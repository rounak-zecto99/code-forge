import java.util.Arrays;

class Solution {
    public int minSelection(int[][] a, int[][] t) {
        if (t.length == 0) return 0;

        Arrays.sort(t, (x, y) -> Integer.compare(x[0], y[0]));
        Arrays.sort(a, (x, y) -> Integer.compare(x[0], y[0]));

        int size = 0;

        for (int i = 0; i < t.length; i++) {
            if (size == 0 || t[size - 1][1] < t[i][0]) {
                t[size++] = t[i];
            } else {
                t[size - 1][1] = Math.max(t[size - 1][1], t[i][1]);
            }
        }

        int i = 0, j = 0;
        int p = t[0][0];
        int ans = 0;

        while (j < size) {
            int farthest = -1;

            while (i < a.length && a[i][0] <= p) {
                farthest = Math.max(farthest, a[i][1]);
                i++;
            }

            if (farthest < p) return -1;

            ans++;

            while (j < size && t[j][1] <= farthest) {
                j++;
            }

            if (j < size) {
                p = Math.max(farthest, t[j][0]);
            }
        }

        return ans;
    }
}