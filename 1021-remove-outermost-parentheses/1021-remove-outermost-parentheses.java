class Solution {
    public String removeOuterParentheses(String s) {
        int depth = 0;
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                depth++;

                if (depth > 1)
                    sb.append(ch);
            } else {
                if (depth > 1)
                    sb.append(ch);

                depth--;
            }
        }

        return sb.toString();
    }
}