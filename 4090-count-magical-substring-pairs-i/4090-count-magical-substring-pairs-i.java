class Solution {
    public int countMagicalPairs(String s) {
        int n = s.length();
        int[][] distinct = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int count = 0;

            for (int j = i; j < n; j++) {
                int c = s.charAt(j) - 'a';

                if (freq[c]++ == 0) {
                    count++;
                }

                distinct[i][j] = count;
            }
        }

        int ans = 0;

        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i <= j; i++) {
                for (int k = j + 1; k < n; k++) {
                    if (distinct[i][j] == distinct[j + 1][k]) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}