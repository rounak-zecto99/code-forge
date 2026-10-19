class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int last1 = -1;
        int last2 = -1;
        int best = Integer.MAX_VALUE;

        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                last1 = i;
            }

            if (wordsDict[i].equals(word2)) {
                last2 = i;
            }

            if (last1 != -1 && last2 != -1) {
                best = Math.min(best, Math.abs(last1 - last2));
            }
        }

        return best;
    }
}