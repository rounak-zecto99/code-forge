class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {

        int i = 0;
        int j = 0;
        int num = 0;

        while (i < abbr.length()) {

            char ch = abbr.charAt(i);

            if (Character.isDigit(ch)) {

                if(num == 0 && ch == '0')
                return false;

                num = num * 10 + (ch - '0');
                i++;
                
                continue;
            }

            if (num != 0) {
                j += num;
                num = 0;
                continue;
            }

            if (j < word.length() && word.charAt(j) != ch) {
                return false;
            }
            j++;
            i++;
        }

        return (j+num) == word.length();
    }
}