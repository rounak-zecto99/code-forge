class Solution {
    public char repeatedCharacter(String s) {
        int mask = 0;

        for (char a : s.toCharArray()) {
            if ((mask & (1 << (a - 'a'))) != 0)
                return a;
            mask = mask | (1 << (a - 'a'));
        }
        return ' ';
    }
}