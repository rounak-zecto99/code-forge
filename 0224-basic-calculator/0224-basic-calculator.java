class Solution {
    public int calculate(String s) {
        int n = s.length();

        int[] stack = new int[n];
        int top = -1;

        int result = 0;
        int sign = 1;
        int num = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '+') {
                result += num * sign;
                num = 0;
                sign = 1;
            } else if (ch == '-') {
                result += num * sign;
                num = 0;
                sign = -1;
            } else if (ch == '(') {
                stack[++top] = result;
                stack[++top] = sign;
                result = 0;
                num = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * num;
                num = 0;

                result *= stack[top--];
                result += stack[top--];
            }
        }
        result += sign * num;
        return result;
    }
}