class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int left = 0;
        int best = 0;

        char first = '\0';
        char second = '\0';

        int firstIndex = -1;
        int secondIndex = -1;

        for (int right = 0; right < s.length(); right++) {

            char cur = s.charAt(right);

            if (cur == first) {
                firstIndex = right;
            }
            else if (cur == second) {
                secondIndex = right;
            }
            else {
                // Third distinct character

                if (firstIndex < secondIndex) {
                    left = firstIndex + 1;

                    first = cur;
                    firstIndex = right;
                }
                else {
                    left = secondIndex + 1;

                    second = cur;
                    secondIndex = right;
                }
            }

            best = Math.max(best, right - left + 1);
        }

        return best;
    }
}
