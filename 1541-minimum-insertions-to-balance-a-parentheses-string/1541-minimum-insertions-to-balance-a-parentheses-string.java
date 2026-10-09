
class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int need = 0; // Number of ')' still required

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // An odd need means a previous '(' needs
                // one ')' before we start this new pair.
                if (need % 2 == 1) {
                    insertions++;
                    need--;
                }

                need += 2;
            } else {
                need--;

                // No opening bracket available for this ')'
                if (need < 0) {
                    insertions++;
                    need = 1;
                }
            }
        }

        return insertions + need;
    }
}