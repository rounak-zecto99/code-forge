class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;

        int[] stack = new int[n];
        int top = -1;

        double[] answer = new double[n];
        Arrays.fill(answer, -1.0);

        for (int i = n - 1; i >= 0; i--) {
            while (top != -1) {
                int j = stack[top];

                if (cars[i][1] <= cars[j][1]) {
                    top--;
                    continue;
                }

                double time = (double) (cars[j][0] - cars[i][0]) / (cars[i][1] - cars[j][1]);

                if (answer[j] != -1 && time > answer[j]) {
                    top--;
                    continue;
                }
                answer[i] = time;
                break;
            }
            stack[++top] = i;
        }
        return answer;
    }
}