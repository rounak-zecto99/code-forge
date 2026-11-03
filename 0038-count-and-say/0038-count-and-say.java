class Solution {
    String ans = "1";

    public String countAndSay(int n) {
        if (n == 1)
            return ans;

        int[][] stack = new int[ans.length() << 1][2];
        int top = -1;

        for (char ch : ans.toCharArray()) {
            if (top != -1 && stack[top][0] == ch) {
                stack[top][1]++;
            } else {
                stack[++top] = new int[] { ch, 1 };
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= top; i++) {
            sb.append(stack[i][1]);
            sb.append((char) stack[i][0]);
        }
        ans = sb.toString();

        return countAndSay(n - 1);
    }
}
