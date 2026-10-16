class Solution {
    public int calculate(String s) {
        int n = s.length();

        int[][] stack = new int[n + 1][n + 1];
        int[] top = new int[n + 1];
        char[] bracketSign = new char[n + 1];

        Arrays.fill(top, -1);

        int level = 0;
        int num = 0;
        char sign = '+';

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/'
                    || i == n - 1
                    || (i + 1 < n && s.charAt(i + 1) == ')')) {

                if (sign == '+') {
                    stack[level][++top[level]] = num;
                } else if (sign == '-') {
                    stack[level][++top[level]] = -num;
                } else if (sign == '*') {
                    stack[level][top[level]] *= num;
                } else if (sign == '/') {
                    stack[level][top[level]] /= num;
                }

                sign = ch;
                num = 0;
            }

            if (ch == '(') {
                bracketSign[level + 1] = sign;
                level++;
                top[level] = -1;
                sign = '+';
                num = 0;
            } else if (ch == ')') {
                int value = 0;

                while (top[level] >= 0) {
                    value += stack[level][top[level]--];
                }

                level--;
                sign = bracketSign[level + 1];

                if (sign == '+') {
                    stack[level][++top[level]] = value;
                } else if (sign == '-') {
                    stack[level][++top[level]] = -value;
                } else if (sign == '*') {
                    stack[level][top[level]] *= value;
                } else if (sign == '/') {
                    stack[level][top[level]] /= value;
                }

                sign = ' ';
                num = 0;
            }
        }

        int ans = 0;

        while (top[0] >= 0) {
            ans += stack[0][top[0]--];
        }

        return ans;
    }
}