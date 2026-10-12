class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] hash = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            hash[word1.charAt(i) - 'a']++;
            hash[word2.charAt(i) - 'a']--;
        }

        for (int x : hash) {
            if (Math.abs(x) > 3)
                return false;
        }
        return true;
    }
}