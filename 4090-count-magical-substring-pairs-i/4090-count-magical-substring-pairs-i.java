class Solution {
    public int countMagicalPairs(String s) {
        int n = s.length();
        long count = 0;

        for (int j = 0; j < n - 1; j++) {
            int[] leftFreq = new int[27];
            boolean[] seenLeft = new boolean[26];
            int distinct = 0;
            for (int i = j; i >= 0; i--) {
                int c = s.charAt(i) - 'a';
                if (!seenLeft[c]) {
                    seenLeft[c] = true;
                    distinct++;
                }
                leftFreq[distinct]++;
            }

            int[] rightFreq = new int[27];
            boolean[] seenRight = new boolean[26];
            distinct = 0;
            for (int k = j + 1; k < n; k++) {
                int c = s.charAt(k) - 'a';
                if (!seenRight[c]) {
                    seenRight[c] = true;
                    distinct++;
                }
                rightFreq[distinct]++;
            }

            for (int d = 1; d <= 26; d++) {
                count += (long) leftFreq[d] * rightFreq[d];
            }
        }

        return (int) count;
    }
}