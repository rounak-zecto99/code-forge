class Solution {
    public boolean halvesAreAlike(String s) {
        int len = s.length() >> 1;

        int i = 0;
        int j = len;

        int count = 0;

        while (i < len ) {
            if(isVowel(s.charAt(i++)))
            count++;

            if(isVowel(s.charAt(j++)))
            count--;
        }
        return count == 0;
    }

    public boolean isVowel(char ch) {
        if(ch =='a' || ch == 'e'|| ch == 'i' ||ch == 'o'||ch== 'u'||ch =='A'||ch == 'E'||ch =='I'||ch == 'O'||ch == 'U')
        return true;

        return false;
    }
}