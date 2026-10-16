class Solution {
    public int calculate(String s) {
        int n = s.length();
        Deque<Deque<Integer>> stack = new ArrayDeque<>();
        stack.push(new ArrayDeque<>());

        int num = 0;
        char sign = '+';

        for (int i = 0; i < n; i++) {
            // System.out.println(Arrays.toString(stack));
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if (ch == '+' || ch == '-' || ch == '/' || ch == '*'|| i == (n-1) || s.charAt(i+1) == ')' || s.charAt(i+1) == ')'){
                if(sign == '+'){
                    stack.peek().push(num);
                }
                else if(sign == '-'){
                    stack.peek().push(-num);
                }
                else if(sign == '*'){
                    stack.peek().push(stack.peek().pop() * num);
                }
                else if(sign == '/'){
                    stack.peek().push(stack.peek().pop() / num);
                }

                sign = ch;
                num = 0;
            }
            else if(ch == '('){
                Deque<Integer> st = new ArrayDeque<>();
                st.push((int)sign);
                stack.push(st);
                stack.push(new ArrayDeque<>());

                    num = 0;
                    sign = '+';
            }
             if(ch == ')'){
                int ans = 0;

                for(int j : stack.peek()){
                    ans += j;
                }
                stack.pop();

                int bracket_sign =  stack.pop().pop();

                if(bracket_sign == '+'){
                    stack.peek().push(ans);
                }
                else if(bracket_sign == '-'){
                    stack.peek().push(-ans);
                }
                else if(bracket_sign == '*'){
                    stack.peek().push(stack.peek().pop() * ans);
                }
                else if(bracket_sign == '/'){
                    stack.peek().push(stack.peek().pop() / ans);
                }

                sign = 99;
                num = 0;
            }
        }

        int ans = 0;

        while(!stack.peek().isEmpty()){
            ans += stack.peek().pop();
        }
        return ans;
    }
}