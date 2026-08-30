class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int[] ans = new int[asteroids.length];
        int top = -1;

        for (int nums : asteroids) {
            if (nums > 0) {
                ans[++top] = nums;
            } else {
                int curr = -1 * nums;
                while (top != -1 && ans[top] > 0) {  //if curr top is positive
                    if (Math.abs(ans[top]) < curr) {
                        top--;
                    } else {
                        break;
                    }
                }
                if (top != -1 && ans[top] > 0) {  //if curr top is positive
                    if (ans[top] > curr) {
                        continue;
                    }
                    if (ans[top] == curr) {
                        top--;

                    }
                } else {
                    ans[++top] = nums;
                }
            }
 
        }
        return Arrays.copyOfRange(ans, 0, ++top);
    }
}