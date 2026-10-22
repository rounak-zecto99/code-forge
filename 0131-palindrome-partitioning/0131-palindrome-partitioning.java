class Solution {
    int[][] memo;

    public boolean isVal(String s, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (memo[left][right] != -1) {
            return memo[left][right] == 1;
        }

        if (s.charAt(left) != s.charAt(right)) {
            memo[left][right] = 0;
            return false;
        }

        boolean ans = isVal(s, left + 1, right - 1);
        memo[left][right] = ans ? 1 : 0;

        return ans;
    }

    public List<List<String>> partition(String s) {
        int n = s.length();
        memo = new int[n][n];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        List<List<String>> list = new ArrayList<>();
        helper(list, new ArrayList<>(), 0, s);
        return list;
    }

    public void helper(List<List<String>> list, List<String> row,
                       int index, String s) {
        if (index == s.length()) {
            list.add(new ArrayList<>(row));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isVal(s, index, i)) {
                row.add(s.substring(index, i + 1));

                helper(list, row, i + 1, s);

                row.remove(row.size() - 1);
            }
        }
    }
}