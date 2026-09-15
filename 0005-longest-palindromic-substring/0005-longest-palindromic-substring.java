class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int left = expand(s, i, i);
            int right = expand(s, i, i + 1);

            int length = Math.max(left, right);

            if (length > max) {
                start = i - ((length - 1) >> 1);
                max = length;
            }
        }
        return s.substring(start, start + max);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() &&
                s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}