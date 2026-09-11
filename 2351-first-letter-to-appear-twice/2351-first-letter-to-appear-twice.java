class Solution {
    public char repeatedCharacter(String s) {
        int mask = 0;

        for (char c : s.toCharArray()) {
            int bit = 1 << (c - 'a');

            if ((mask & bit) != 0)
                return c;

            mask |= bit;
        }
        return ' ';
    }
}