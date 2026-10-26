class Solution {
    public int bestClosingTime(String customers) {
        int penalty = 0;

        char[] ch = customers.toCharArray();

        for (char a : ch) {
            if (a == 'N')
                penalty++;
        }
        int min = penalty;
        int bestTime = ch.length;

        for (int i = ch.length - 1; i >= 0; i--) {
            if (ch[i] == 'Y') {
                penalty++;
            } else {
                penalty--;

                if (penalty <= min) {
                    bestTime = i;
                    penalty = min;
                }
            }
        }
        return bestTime;

    }
}