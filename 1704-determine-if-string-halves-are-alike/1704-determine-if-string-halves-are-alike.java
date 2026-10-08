class Solution {
    public boolean halvesAreAlike(String s) {
        int len = s.length() >> 1;

        int i = 0;
        int j = len;

        int count = 0;

        while (i < len && j < (len << 1)) {
            if(isVowel(s.charAt(i++)+""))
            count++;

            if(isVowel(s.charAt(j++)+""))
            count--;
        }
        return count == 0;
    }

    public boolean isVowel(String ch) {
        String vowel = "aeiouAEIOU";
        return vowel.contains(ch);
    }
}