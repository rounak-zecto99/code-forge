class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            sum += (i + 1) * (26 - (cur - 'a'));
        }
        return sum;
    }
}