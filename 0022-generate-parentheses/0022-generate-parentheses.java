class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(list, new StringBuilder(), 0, 0, n);
        return list;
    }

    public void helper(List<String> list, StringBuilder sb, int open, int close, int length) {
        if (sb.length() == length << 1) {
            list.add(sb.toString());
            return;
        }
        if (open < length) {
            sb.append('(');
            helper(list, sb, open + 1, close, length);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(')');
            helper(list, sb, open, close + 1, length);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}