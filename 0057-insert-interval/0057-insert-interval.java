class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        if(n == 0)
        return new int[][]{newInterval};

        int[][] ans = new int[n + 1][2];
        ans[0] = intervals[0];
        int size = 0;
        int j = 1;
        boolean inserted = false;

        if (newInterval[0] < intervals[0][0]) {
            ans[0] = newInterval;
            inserted = true;
            j = 0;
        }

        while (j < n) {
            if (!inserted) {
                if (ans[size][1] >= newInterval[0]) {
                    ans[size][1] = Math.max(ans[size][1], newInterval[1]);
                    inserted = true;
                } else if (ans[size][1] >= intervals[j][1]) {
                    ans[size][1] = Math.max(ans[size][1], newInterval[1]);
                    j++;
                } else {
                    if (intervals[j][0] < newInterval[0]) {
                        ans[++size] = intervals[j];
                        j++;
                    } else {
                        ans[++size] = newInterval;
                        inserted = true;
                    }
                }
            } else {
                if (ans[size][1] >= intervals[j][0]) {
                    ans[size][1] = Math.max(ans[size][1], intervals[j][1]);
                } else {
                    ans[++size] = intervals[j];
                }
                j++;
            }
        }
        if (!inserted) {
            if (ans[size][1] >= newInterval[0]) {
                ans[size][1] = Math.max(ans[size][1], newInterval[1]);
            } else {
                ans[++size] = newInterval;
            }
        }
        return Arrays.copyOf(ans, ++size);
    }
}