class Solution {
    public String removeKdigits(String num, int k) {

        int n = num.length();
        char[] stack = new char[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            char cur = num.charAt(i);

            while (k > 0 && top != -1 && stack[top] > cur) {
                top--;
                k--;
            }
            stack[++top] = cur;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            if (sb.isEmpty() && stack[i] == '0' && i != top)
                continue;

            sb.append(stack[i]);
        }
        while(k-->0){
            if(!sb.isEmpty())
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.isEmpty()?"0":sb.toString();
    }
}