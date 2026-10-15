class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;

        int[][] time = new int[n][2];

        for (int i = 0; i < n; i++) {
            time[i][0] = position[i];
            time[i][1] = speed[i];
        }
        Arrays.sort(time, (a, b) -> Integer.compare(a[0], b[0]));

        double[] stack = new double[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            double x = (double) (target - time[i][0]) / time[i][1];

            while (top != -1 && stack[top] <= x) {
                --top;
            }
            stack[++top] = x;
        }
        return ++top;
    }
}