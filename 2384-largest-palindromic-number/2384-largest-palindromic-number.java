class Solution {
    public String largestPalindromic(String num) {
        int[] freq = new int[10];

        for (char c : num.toCharArray()) {
            freq[c - '0']++;
        }

        StringBuilder left = new StringBuilder();

        // Build the left half
        for (int d = 9; d >= 0; d--) {
            int pairs = freq[d] / 2;

            // Don't put zero at the beginning
            if (d == 0 && left.length() == 0) {
                pairs = 0;
            }

            for (int i = 0; i < pairs; i++) {
                left.append((char) ('0' + d));
            }

            freq[d] -= pairs * 2;
        }

        // Find the largest remaining digit for the middle
        char middle = 0;

        for (int d = 9; d >= 0; d--) {
            if (freq[d] > 0) {
                middle = (char) ('0' + d);
                break;
            }
        }

        // No non-zero pair exists
        if (left.length() == 0) {
            return middle == 0 ? "0" : String.valueOf(middle);
        }

        String right = left.reverse().toString();

        return left.reverse().toString()
                + (middle == 0 ? "" : String.valueOf(middle))
                + right;
    }
}