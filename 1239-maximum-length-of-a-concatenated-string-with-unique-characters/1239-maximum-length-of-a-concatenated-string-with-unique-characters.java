class Solution {
    public int maxLength(List<String> arr) {
        boolean[] taken = new boolean[26];
        return helper(arr, taken, 0);
    }

    public int helper(List<String> arr, boolean[] taken, int index) {
        if (index == arr.size())
            return 0;

        String curr = arr.get(index);

        for (int i = 0; i < curr.length(); i++) {
            int ch = curr.charAt(i) - 'a';

            if (taken[ch]) {
                for (int j = 0; j < i; j++) {
                    taken[curr.charAt(j) - 'a'] = false;
                }
                return helper(arr, taken, index + 1);
            }

            taken[ch] = true;
        }
        int left = curr.length() + helper(arr, taken, index + 1);

        for (int i = 0; i < curr.length(); i++) {
            taken[curr.charAt(i) - 'a'] = false;
        }

        int right = helper(arr, taken, index + 1);

        return Math.max(left, right);
    }
}