import java.util.*;

class Solution {
    private int i;

    public int calculate(String s) {
        i = 0;
        return evaluate(s);
    }

    private int evaluate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char sign = '+';

        while (i < s.length()) {
            char ch = s.charAt(i++);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if (ch == '(') {
                num = evaluate(s);
            }

            if (ch == ')' || i == s.length()
                    || (ch != ' ' && !Character.isDigit(ch) && ch != '(')) {

                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                num = 0;
                sign = ch;
            }

            if (ch == ')') {
                break;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}